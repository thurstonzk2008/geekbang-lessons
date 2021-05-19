package org.geektimes.projects.user.mybatis.annotation;

import org.apache.commons.configuration.Configuration;
import org.apache.ibatis.annotations.Mapper;
import org.geektimes.projects.user.mybatis.annotation.MyBatisBeanDefinitionRegistrar;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 激活 MyBatis
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since TODO
 * Date : 2021-05-06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@MapperScan
@Import(MyBatisBeanDefinitionRegistrar.class)
public @interface EnableMyBatis {
        /**
         * @return the bean name of {@link SqlSessionFactoryBean}
         */
        String value() default "sqlSessionFactoryBean";

        /**
         * @return DataSource bean name
         */
        String dataSource() default "dataSource";

        /**
         * the location of {@link Configuration}
         *
         * @return
         */
        String configLocation();

        /**
         * @return the location of {@link Mapper}
         * @see MapperScan
         */
        String[] mapperLocations() default {};

        String environment() default "SqlSessionFactoryBean";

        @AliasFor(annotation = MapperScan.class)
        String[] basePackages();
        String typeHandlersPackage() default "";

        String typeAliasesPackage() default "";

}
