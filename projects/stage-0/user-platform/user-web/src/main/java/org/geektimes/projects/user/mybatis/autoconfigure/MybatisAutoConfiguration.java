package org.geektimes.projects.user.mybatis.autoconfigure;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.geektimes.projects.user.mybatis.annotation.EnableMyBatis;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
@ComponentScan({"org.geektimes.projects.user.mybatis","org.geektimes.projects.user.service"})
@EnableMyBatis(value = "SqlSessionFactoryBean",
        dataSource = "dataSource",
        configLocation = "classpath:META-INF/mybatis-config.xml",
        mapperLocations = "classpath:mappers/*.xml",
        basePackages = "org.geektimes.projects.user.mybatis.mapper",
        typeAliasesPackage = "org.geektimes.projects.user.domain")
public class MybatisAutoConfiguration {

//    @Bean
//    public DataSource dataSource() {
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setDatabaseName("mybatis");
//        dataSource.setServerName("localhost");
//        dataSource.setPort(3306);
//        dataSource.setUser("zhk");
//        dataSource.setPassword("Password123");
//
//        return dataSource;
//    }
}
