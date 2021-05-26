package org.geektimes.my.mybatis.configuration;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-05-13 11:10 上午
 * @Version 1.0
 **/
@Configuration
//@ComponentScan({"org.geektimes.projects.user.mybatis","org.geektimes.projects.user.service"})
public class MySQLConfiguration {
    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("mybatis");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser("zhk");
        dataSource.setPassword("Password123");

        return dataSource;
    }
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("org.geektimes.projects.user.mybatis.mapper");
//        mapperScannerConfigurer.setAddToConfig(true);
//        return  mapperScannerConfigurer;
//    }
}
