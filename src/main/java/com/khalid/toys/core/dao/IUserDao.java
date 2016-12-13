package com.khalid.toys.core.dao;

import com.khalid.toys.core.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 费玥 on 2016/12/8.
 */

@Repository
public interface IUserDao extends PagingAndSortingRepository<User,String> {

    User findByEmail(String email);

    User findByLoginName(String loginName);

    User findByEmailOrMobile(String email , String mobile);
}
