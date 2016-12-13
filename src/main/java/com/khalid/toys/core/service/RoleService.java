package com.khalid.toys.core.service;

import com.khalid.toys.core.dao.IRoleDao;
import com.khalid.toys.core.domain.Role;
import com.khalid.toys.core.utils.CacheNamespaceEnum;
import com.khalid.toys.core.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by 费玥 on 2016/12/13.
 */
public class RoleService {

    @Autowired
    private IRoleDao iRoleDao;

    public List<Role> findAllRole() {
        List<Role> roles = new ArrayList<>();
        try {
            if (CacheUtil.hasHkey(CacheNamespaceEnum.ROLE_NAME_SPACE + "role", "v_user")) {
                Set<Object> allRoleNames = CacheUtil.hAllField(CacheNamespaceEnum.ROLE_NAME_SPACE + "role");
                for (Object roleName : allRoleNames) {
                    Role role = CacheUtil.hGetObject(CacheNamespaceEnum.ROLE_NAME_SPACE + "role", (String) roleName, Role.class);
                    roles.add(role);
                }
                return roles;
            }
        } catch (Exception ex) {
            Iterable<Role> allRoles = iRoleDao.findAll();
            for (Role role : allRoles) {
                roles.add(role);
            }
            return roles;
        }
        Iterable<Role> allRoles = iRoleDao.findAll();
        for (Role role : allRoles) {
            roles.add(role);
        }
        return roles;
    }

    public boolean authorized(String id, String s, String s1) {
        return false;
    }
}
