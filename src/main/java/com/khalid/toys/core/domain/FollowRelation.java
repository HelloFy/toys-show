package com.khalid.toys.core.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 费玥 on 2017/1/20.
 */
@Entity
@Table(name = "ts_follow_relation")
public class FollowRelation implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "followed_Id", length = 255 ,nullable = false ,unique = false)
    private String followedId;

    @Column(name = "fans_id", length = 255 ,nullable = false ,unique = false)
    private String fansId;

    @Column(name = "is_mutual", length = 255 ,nullable = false ,unique = false)
    private boolean isMutual = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFollowId() {
        return followedId;
    }

    public void setFollowId(String followId) {
        this.followedId = followId;
    }

    public String getFansId() {
        return fansId;
    }

    public void setFansId(String fansId) {
        this.fansId = fansId;
    }

    public boolean isMutual() {
        return isMutual;
    }

    public void setMutual(boolean mutual) {
        isMutual = mutual;
    }
}
