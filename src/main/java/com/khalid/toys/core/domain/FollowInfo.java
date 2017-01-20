package com.khalid.toys.core.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 费玥 on 2017/1/20.
 */
@Entity
@Table(name = "ts_follow_info")
public class FollowInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "user_id", length = 255 ,nullable = false ,unique = true)
    private String userId;

    @Column(name = "follow_count", length = 30 ,nullable = false ,unique = false)
    private String followCount = "0";

    @Column(name = "fans_count", length = 30 ,nullable = false ,unique = false)
    private String fansCount = "0";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowCount() {
        return followCount;
    }

    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

    public String getFansCount() {
        return fansCount;
    }

    public void setFansCount(String fansCount) {
        this.fansCount = fansCount;
    }
}
