package com.khalid.toys.core.dao;

import com.khalid.toys.core.domain.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 费玥 on 2016/12/12.
 */
@Repository
public interface IUserRoleDao extends CrudRepository<UserRole,String> {
}
