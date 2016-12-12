package com.khalid.toys.core.domain;


import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 费玥 on 2016/12/8.
 */
@Entity
@Table(name = "ts_user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "login_name" , length = 20 , nullable = false , unique = true)
    private String loginName;

    @JSONField(serialize = false)
    @Column(name = "credence" ,length = 256 , nullable = false)
    private char[] credence;

    @Column(name = "mobile" , length = 20 , nullable = false , unique = true)
    private String mobile;

    @Column(name = "email" , length = 30 , nullable = true , unique = true)
    private String email;

    @Column(name = "sex", length = 5 , nullable = true)
    private String sex;

    @JSONField (format="yyyy-MM-dd")
    @Column(name = "reg_time" , nullable = false )
    @Temporal(TemporalType.DATE)
    private Date regTime;

    @JSONField (format="yyyy-MM-dd")
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

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

}
