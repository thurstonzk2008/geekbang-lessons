package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.geektimes.projects.user.cache.RedisCacheManager;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-05-06 6:13 下午
 * @Version 1.0
 **/
@Service
@CacheConfig(cacheManager="myRedisCacheManager")
public class CacheServiceImpl implements CacheService{
    @Override
    @Cacheable(cacheNames = "redisCache")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("testName");
        System.out.println("get user from real");
        return user;
    }
    @Override
    @CachePut(cacheNames = "redisCache")
    public  User getUser1(){
        User user = new User();
        user.setId(2L);
        user.setName("testName");
        System.out.println("get user from real");
        return user;
    }
}
