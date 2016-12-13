package com.khalid.toys.core.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 费玥 on 2016/12/9.
 */
@Entity
@Table(name = "ts_role")
public class Role implements Serializable,GrantedAuthority {

    private static final long serialVersionUID = 6685076329274779790L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "role_name", length = 10 ,nullable = false ,unique = true)
    private String roleName;

    @Column(name = "role_desc" , nullable = true)
    private String roleDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    @JSONField(serialize = false)
    public String getAuthority() {
        return roleName;
    }
}
