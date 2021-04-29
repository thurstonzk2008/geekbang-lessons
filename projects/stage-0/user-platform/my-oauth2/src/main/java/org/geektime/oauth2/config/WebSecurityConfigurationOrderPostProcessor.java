package org.geektime.oauth2.config;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对 WebSecurityConfigurerAdapter 类型的config进行排序
 *
 * @author zhuhk
 * @create 2021-04-29 9:26 上午
 * @Version 1.0
 **/
@Order(Ordered.LOWEST_PRECEDENCE)
public class WebSecurityConfigurationOrderPostProcessor implements BeanDefinitionRegistryPostProcessor, BeanFactoryAware, BeanClassLoaderAware {



    private DefaultListableBeanFactory defaultListableBeanFactory;


    private ClassLoader classLoader;


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] webSecurityConfigurerBeanNames = defaultListableBeanFactory.getBeanNamesForType(WebSecurityConfigurerAdapter.class);
        if (webSecurityConfigurerBeanNames == null || webSecurityConfigurerBeanNames.length == 0){
            return;
        }
        List<BeanDefinition> beanDefinitions = Arrays.asList(webSecurityConfigurerBeanNames).stream().map(registry::getBeanDefinition).sorted(Comparator.comparingInt(item -> {
            if (!(item instanceof AbstractBeanDefinition)){
                return Ordered.HIGHEST_PRECEDENCE;
            }
            AbstractBeanDefinition item1 = (AbstractBeanDefinition) item;
            Order order = null;
            if (!item1.isEnforceDestroyMethod()){
                order = AnnotationUtils.getAnnotation(loadClass(item.getBeanClassName()), Order.class);
            }
            if (order == null) {
                return Ordered.HIGHEST_PRECEDENCE;
            } else {
                return order.value();
            }
        })).collect(Collectors.toList());

        for (int i = 0 ; i < beanDefinitions.size() ; i ++){
            BeanDefinition beanDefinition = beanDefinitions.get(i);
            registry.removeBeanDefinition(webSecurityConfigurerBeanNames[i]);
            registry.registerBeanDefinition(webSecurityConfigurerBeanNames[i] , beanDefinition);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    private Class loadClass(String className){
        try {
            return classLoader.loadClass(className);
        }catch (Exception e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}
