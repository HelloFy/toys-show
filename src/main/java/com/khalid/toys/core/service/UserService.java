package com.khalid.toys.core.service;

import com.khalid.toys.core.dao.IUserDao;
import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 费玥 on 2016/12/8.
 */
@Service
public class UserService {

    @Autowired
    private IUserDao iUserDao;

    public void regIn(User user){
        user.setCredence(SystemService.encodePassWord(user.getCredence()));
        CacheUtil.put(user.getLoginName(),"u");
        iUserDao.save(user);
    }

    public User findByEmail(String email){
       return iUserDao.findByEmail(email);
    }
}
