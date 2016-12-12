package com.khalid.toys.core.service;

import com.khalid.toys.core.dao.IRoleDao;
import com.khalid.toys.core.dao.IUserDao;
import com.khalid.toys.core.dao.IUserRoleDao;
import com.khalid.toys.core.domain.Role;
import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.domain.UserRole;
import com.khalid.toys.core.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    public void regIn(User user){
        user.setCredence(SystemService.encodePassWord(user.getCredence()));
        CacheUtil.put(user.getLoginName(),"has");
        CacheUtil.put(user.getMobile(),"has");
        user.setRegTime(new Date());
        User userSaved = iUserDao.save(user);
        Role commonRole = null;
        try {
            commonRole =  CacheUtil.getObject("common_user",Role.class);
        }
        catch (Exception ex){
            commonRole =iRoleDao.findOne("1");
        }
        UserRole userRole =  new UserRole();
        userRole.setRoleId(commonRole.getId());
        userRole.setUserId(userSaved.getId());
        iUserRoleDao.save(userRole);
    }

    public boolean isExistLoginName(String loginName){
        try {
            return CacheUtil.hasKey(loginName);
        }
        catch (Exception ex){
            return findByLoginName(loginName) != null;
        }
    }

    public boolean isExistMobile(String mobile){
        try {
            return CacheUtil.hasKey(mobile);
        }
        catch (Exception ex){
            return findByEmail(mobile) != null;
        }
    }


    public User findByEmail(String email){
       return iUserDao.findByEmail(email);
    }

    public User findByLoginName(String loginName){
        return iUserDao.findByLoginName(loginName);
    }
}
