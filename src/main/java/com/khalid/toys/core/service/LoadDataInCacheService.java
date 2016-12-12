package com.khalid.toys.core.service;

import com.khalid.toys.core.dao.IUserDao;
import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * Created by 费玥 on 2016/12/12.
 */
@Component
public class LoadDataInCacheService implements CommandLineRunner {
    @Autowired
    private IUserDao iUserDao;

    @Override
    public void run(String... strings) throws Exception {
        for (int i = 0 ; ;i++){
            PageRequest page = new PageRequest(i,100);
            Page<User> uPage = iUserDao.findAll(page);
            Iterator<User> iterator = uPage.iterator();
            while (iterator.hasNext()){
                User user = iterator.next();
                if (CacheUtil.hasKey(user.getLoginName())){
                    continue;
                }
                CacheUtil.put(user.getLoginName(),"has");
            }
            if (i + 1 >= uPage.getTotalPages()){
                return;
            }
        }
    }
}
