package org.geektimes.my.mybatis.annotation;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * TODO Comment
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since TODO
 * Date : 2021-05-06
 */
public class MyBatisBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(SqlSessionFactoryBean.class);

        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableMyBatis.class.getName());
        /**
         *  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
         *   <property name="dataSource" ref="dataSource" />
         *   <property name="mapperLocations" value="classpath*:" />
         *  </bean >
         */
        beanDefinitionBuilder.addPropertyReference("dataSource", (String) attributes.get("dataSource"));
        // Spring String 类型可以自动转化 Spring Resource
        beanDefinitionBuilder.addPropertyValue("configLocation", attributes.get("configLocation"));
        beanDefinitionBuilder.addPropertyValue("mapperLocations", attributes.get("mapperLocations"));
        beanDefinitionBuilder.addPropertyValue("environment", resolvePlaceholder(attributes.get("environment")));

        beanDefinitionBuilder.addPropertyValue("typeHandlersPackage",
                attributes.get("typeHandlersPackage"));
        beanDefinitionBuilder.addPropertyValue("typeAliasesPackage",
                attributes.get("typeAliasesPackage"));

        // 自行添加其他属性
        // SqlSessionFactoryBean 的 BeanDefinition
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        String beanName = (String) attributes.get("value");

        registry.registerBeanDefinition(beanName,beanDefinition);

    }

    private Object resolvePlaceholder(Object value) {
        if (value instanceof String) {
            return environment.resolvePlaceholders((String) value);
        }
        return value;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
