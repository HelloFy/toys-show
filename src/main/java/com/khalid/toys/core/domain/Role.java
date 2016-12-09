package com.khalid.toys.core.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 费玥 on 2016/12/9.
 */
@Entity
@Table(name = "ts_role")
public class Role {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "role_name", length = 10 ,nullable = false ,unique = true)
    private String roleName;

    @Column(name = "role_desc" , nullable = true)
    private String roleDesc;
}
