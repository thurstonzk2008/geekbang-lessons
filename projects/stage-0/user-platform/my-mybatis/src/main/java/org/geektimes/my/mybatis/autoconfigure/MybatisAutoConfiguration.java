package org.geektimes.my.mybatis.autoconfigure;

import org.geektimes.my.mybatis.annotation.EnableMyBatis;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.geektimes.my.mybatis.configuration.MySQLConfiguration;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-05-25 6:39 下午
 * @Version 1.0
 **/
@Configuration
//@ConditionalOnClass({ SqlSessionFactory.class, SqlSessionFactoryBean.class })
//@ConditionalOnSingleCandidate(DataSource.class)
//@ComponentScan({"org.geektimes.my.mybatis.configuration.MySQLConfiguration"})
@ComponentScan("org.geektimes.my.mybatis.configuration")
@EnableMyBatis(value = "SqlSessionFactoryBean",
        dataSource = "dataSource",
        configLocation = "classpath:META-INF/mybatis-config.xml",
        mapperLocations = "classpath:mappers/*.xml",
        basePackages = "org.geektimes.projects.user.mybatis.mapper",
        typeAliasesPackage = "org.geektimes.projects.user.domain")
public class MybatisAutoConfiguration {
}
