package com.khalid.toys.core.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by 费玥 on 2016/12/13.
 */
@EnableRedisHttpSession
@Configuration
public class RedisSessionConfigure {
}
