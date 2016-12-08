package com.khalid.toys.core.dao;

import com.khalid.toys.core.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 费玥 on 2016/12/8.
 */

@Repository
public interface IUserDao extends CrudRepository<User,String> {
}
