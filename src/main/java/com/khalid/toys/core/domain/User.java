package com.khalid.toys.core.domain;


import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

/**
 * Created by 费玥 on 2016/12/8.
 */
@Entity
@Table(name = "ts_user")
public class User implements Serializable {

    private static final long serialVersionUID = -7497218176818087231L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "login_name" , length = 20 , nullable = false , unique = true)
    private String loginName;

    @Column(name = "credence" ,length = 256 , nullable = false)
    private char[] credence;

    @Column(name = "mobile" , length = 20 , nullable = false , unique = true)
    private String mobile;

    @Column(name = "email" , length = 30 , nullable = true , unique = true)
    private String email;

    @Column(name = "sex", length = 5 , nullable = true)
    private String sex = "男";

    @Column(name = "reg_time" , nullable = false )
    @Temporal(TemporalType.DATE)
    private Date regTime;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "is_lock")
    private boolean isLock = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public char[] getCredence() {
        return credence;
    }

    public void setCredence(char[] credence) {
        this.credence = credence;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return  "User is " + this.loginName;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public class CustomUserDetail implements UserDetails,Serializable{

        private static final long serialVersionUID = 5202551108400584706L;
        private String username;
        private Set<? extends GrantedAuthority> authorities;

        public CustomUserDetail(String username,Set<? extends GrantedAuthority> authorities){
            this.username =username;
            this.authorities =authorities;
        }

        @Override
        @JSONField(serialize = false)
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.authorities;
        }

        @Override
        @JSONField(serialize = false)
        public String getPassword() {
            return new String(User.this.getCredence());
        }

        @Override
        @JSONField(serialize = false)
        public String getUsername() {
            return username;
        }

        @Override
        @JSONField(serialize = false)
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        @JSONField(serialize = false)
        public boolean isAccountNonLocked() {
            return !User.this.isLock;
        }

        @Override
        @JSONField(serialize = false)
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        @JSONField(serialize = false)
        public boolean isEnabled() {
            return true;
        }

        @JSONField
        public String getUid(){
            return User.this.id;
        }

        @JSONField(serialzeFeatures = {WriteMapNullValue})
        public String getLoginName(){
            return User.this.loginName;
        }

        @JSONField(serialzeFeatures = {WriteMapNullValue})
        public String getMobile(){
            return User.this.mobile;
        }

        @JSONField(serialzeFeatures = {WriteMapNullValue})
        public String getSex(){
            return User.this.sex;
        }

        @JSONField (format="yyyy-MM-dd",serialzeFeatures = {WriteMapNullValue})
        private Date getBirthDay(){
            return User.this.birthday;
        }

        @JSONField(serialzeFeatures = {WriteMapNullValue})
        public String getEmail(){
            return User.this.email;
        }
    }
}
