package com.khalid.toys.core.dao;

import com.khalid.toys.core.domain.FollowInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 费玥 on 2017/1/20.
 */
@Repository
public interface IFollowInfoDao extends CrudRepository<FollowInfo,String> {

}
