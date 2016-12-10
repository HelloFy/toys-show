package com.khalid.toys.test.core.dao.redisCache;

import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.utils.CacheUtil;
import com.khalid.toys.test.core.TestBase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 费玥 on 2016/12/10.
 */
public class TestRedisCache extends TestBase {

    @Test
    public void testSaveString(){
        CacheUtil.put("Hello","World");
        Assert.assertEquals("World", CacheUtil.get("Hello"));
    }

    @Test
    public void testSaveObj(){
        CacheUtil.putObject(user.getLoginName(),user);
        Assert.assertEquals(user.getLoginName(),CacheUtil.getObject(user.getLoginName(),User.class).getLoginName());
    }
}
