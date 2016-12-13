package com.khalid.toys.core.service;

import com.khalid.toys.core.dao.IRoleDao;
import com.khalid.toys.core.dao.IUserDao;
import com.khalid.toys.core.domain.Role;
import com.khalid.toys.core.utils.CacheNamespaceEnum;
import com.khalid.toys.core.utils.CacheUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by 费玥 on 2016/12/12.
 */
@Component
public class LoadDataInCacheService implements CommandLineRunner {
    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private IRoleDao iRoleDao;

    private static Logger logger =  Logger.getLogger(LoadDataInCacheService.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("begin load data in cache...");
        Iterable<Role> allRoles = iRoleDao.findAll();
        for (Role role : allRoles){
            if (!CacheUtil.hasKey(role.getId())){
                CacheUtil.hPutObject(CacheNamespaceEnum.ROLE_NAME_SPACE+"role",role.getRoleName(),role);
            }
        }
        logger.info("end load data in cache...");
    }
}
