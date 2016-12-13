package com.khalid.toys.core.service;

import com.khalid.toys.core.dao.IUserRoleDao;
import com.khalid.toys.core.domain.Role;
import com.khalid.toys.core.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 费玥 on 2016/12/13.
 */
@Service
public class UserRoleService {

    @Autowired
    private IUserRoleDao userRoleDao;

    @Autowired
    private RoleService roleService;

    public List<Role> findRolesWithUID(String id){
        List<UserRole> uRoles = userRoleDao.findByUserId(id);
        List<Role> roles = roleService.findAllRole();
        List<Role> hasRoles = new ArrayList<>();
        for (UserRole uRole : uRoles){
            for (Role role : roles){
                if (role.getId().equals(uRole.getRoleId())){
                    hasRoles.add(role);
                    break;
                }
            }
        }
        return hasRoles;
    }

    public boolean authorized(String id, String targetDomainObject , String permision) {
        Role role = roleService.findByRoleName(permision);
        return userRoleDao.findByUserIdAndRoleId(id,role.getId()) == null ? false : true;
    }
}
