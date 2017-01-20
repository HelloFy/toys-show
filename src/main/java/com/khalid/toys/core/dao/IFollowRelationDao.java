package com.khalid.toys.core.dao;

import com.khalid.toys.core.domain.FollowRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 费玥 on 2017/1/20.
 */
@Repository
public interface IFollowRelationDao extends CrudRepository<FollowRelation,String> {

    List<FollowRelation> findByFansIdAndFollowedId(String fansId, String followedId);
}
