package com.khalid.toys.core.service;

import com.khalid.toys.core.dao.*;
import com.khalid.toys.core.domain.*;
import com.khalid.toys.core.utils.CacheNamespaceEnum;
import com.khalid.toys.core.utils.CacheUtil;
import com.khalid.toys.core.utils.RoleNameConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by 费玥 on 2016/12/8.
 */
@Service
public class UserService {

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private IRoleDao iRoleDao;

    @Autowired
    private IUserRoleDao iUserRoleDao;

    @Autowired
    private IFollowRelationDao iFollowRelationDao;

    @Autowired
    private IFollowInfoDao iFollowInfoDao;

    @Autowired
    private CustomPassWordEncoder customPassWordEncoder;

    public void regIn(User user) throws SQLException {
        if (CacheUtil.hasHkey(CacheNamespaceEnum.USER_LOGINNAME_SPACE + "loginName", user.getLoginName()))
            throw new IllegalStateException("登录名重复");
        if (CacheUtil.hasHkey(CacheNamespaceEnum.USER_MOBILE_SPACE + "mobile", user.getMobile())) {
            throw new IllegalStateException("手机号重复");
        }
        user.setCredence(customPassWordEncoder.encode(new String(user.getCredence())).toCharArray());
        CacheUtil.hPut(CacheNamespaceEnum.USER_LOGINNAME_SPACE + "loginName", user.getLoginName(), "has");
        CacheUtil.hPut(CacheNamespaceEnum.USER_MOBILE_SPACE + "mobile", user.getMobile(), "has");
        user.setRegTime(new Date());
        try {
            User userSaved = iUserDao.save(user);
            Role commonRole = null;
            try {
                commonRole = CacheUtil.hGetObject(CacheNamespaceEnum.ROLE_NAME_SPACE+"role", RoleNameConstant.COMMON_USER, Role.class);
                if (commonRole == null) {
                    commonRole = iRoleDao.findOne("1");
                }
            } catch (Exception ex) {
                commonRole = iRoleDao.findOne("1");
            }
            UserRole userRole = new UserRole();
            userRole.setRoleId(commonRole.getId());
            userRole.setUserId(userSaved.getId());
            FollowInfo followInfo = new FollowInfo();
            followInfo.setUserId(userSaved.getId());
            iFollowInfoDao.save(followInfo);
            iUserRoleDao.save(userRole);
        } catch (Exception ex) {
            CacheUtil.rmHKeys(CacheNamespaceEnum.USER_LOGINNAME_SPACE + "loginName", user.getLoginName());
            CacheUtil.rmHKeys(CacheNamespaceEnum.USER_MOBILE_SPACE + "mobile", user.getMobile());
            throw new SQLException(ex);
        }

    }

    public boolean isExistLoginName(String loginName) {
        try {
            return CacheUtil.hasHkey(CacheNamespaceEnum.USER_LOGINNAME_SPACE + "loginName", loginName);
        } catch (Exception ex) {
            return findByLoginName(loginName) != null;
        }
    }

    public boolean isExistMobile(String mobile) {
        try {
            return CacheUtil.hasHkey(CacheNamespaceEnum.USER_MOBILE_SPACE + "mobile", mobile);
        } catch (Exception ex) {
            return findByEmail(mobile) != null;
        }
    }

    public User findByEmail(String email) {
        return iUserDao.findByEmail(email);
    }

    public User findByLoginName(String loginName) {
        return iUserDao.findByLoginName(loginName);
    }

    public User findByEmailOrMobile(String email ,String mobile) {
        return iUserDao.findByEmailOrMobile(email,mobile);
    }

    public void addFansCount(String userId){
       FollowInfo followInfo = iFollowInfoDao.findOne(userId);
       followInfo.setFansCount(String.valueOf(Integer.getInteger(followInfo.getFansCount())+1));
       iFollowInfoDao.save(followInfo);
    }

    public void addFollowCount(String userId){

    }

    public FollowRelation follow(String fansId,String followId){
        FollowRelation followRelation = new FollowRelation();
        followRelation.setFansId(fansId);
        followRelation.setFollowId(followId);
        List<FollowRelation> fansToFollow = iFollowRelationDao.findByFansIdAndFollowedId(followId,fansId);
        if (!fansToFollow.isEmpty()){
            followRelation.setMutual(true);
            fansToFollow.get(0).setMutual(true);
            iFollowRelationDao.save(fansToFollow);
        }
        iFollowRelationDao.save(followRelation);
        return followRelation;
    }
}
