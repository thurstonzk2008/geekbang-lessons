package org.geektimes.projects.user.service;

import org.geektimes.projects.user.mybatis.annotation.EnableMyBatis;
import org.geektimes.projects.user.mybatis.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-05-18 6:55 上午
 * @Version 1.0
 **/
@Service
@ComponentScan({"org.geektimes.projects.user.mybatis,org.geektimes.projects.user.service"})
@EnableMyBatis(value = "SqlSessionFactoryBean",
        dataSource = "dataSource",
        configLocation = "classpath:META-INF/mybatis-config.xml",
        mapperLocations = "classpath:mappers/*.xml",
        basePackages = "org.geektimes.projects.user.mybatis.mapper",
        typeAliasesPackage = "org.geektimes.projects.user.domain")
public class AnnotationMybatisServiceImpl implements MybatisService{

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public void printUser() {
        System.out.println(usersMapper.getAll());
    }
}
