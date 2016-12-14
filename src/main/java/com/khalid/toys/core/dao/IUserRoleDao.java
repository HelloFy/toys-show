package com.khalid.toys.core.dao;

import com.khalid.toys.core.domain.UserRole;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 费玥 on 2016/12/12.
 */
@Repository
public interface IUserRoleDao extends CrudRepository<UserRole,String> {

    List<UserRole> findByUserId(String uid);

    @Cacheable(value="ts-cache")
    UserRole findByUserIdAndRoleId(String uid, String rid);
}
