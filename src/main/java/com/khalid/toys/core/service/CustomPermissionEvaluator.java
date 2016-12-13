package com.khalid.toys.core.service;

import com.khalid.toys.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.transaction.NotSupportedException;
import java.io.Serializable;

/**
 * Created by 费玥 on 2016/12/13.
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        String username = authentication.getName();
        User user  = userService.findByEmailOrMobile(username,username);
        return userRoleService.authorized(user.getId(), targetDomainObject.toString(), permission.toString());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        try {
            throw new NotSupportedException("不支持的操作.");
        } catch (NotSupportedException e) {
            return false;
        }
    }
}
