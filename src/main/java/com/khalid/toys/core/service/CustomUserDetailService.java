package com.khalid.toys.core.service;

import com.khalid.toys.core.domain.Role;
import com.khalid.toys.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 费玥 on 2016/12/13.
 */
@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(s)){
            throw new UsernameNotFoundException("用户名为空");
        }

        User user = userService.findByEmailOrMobile(s,s);
        if (user == null){
            throw new UsernameNotFoundException("找不到用户");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        List<Role> roles = userRoleService.findRolesWithUID(user.getId());
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(
                s, new String(user.getCredence()),
                true,//是否可用
                true,//是否过期
                true,//证书不过期为true
                true,//账户未锁定为true
                authorities);
    }
}
