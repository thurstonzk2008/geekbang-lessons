package org.geektimes.dependency.injection.context;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * 注册ComponentContextListener进行初始化
 *
 * @author zhuhk
 * @create 2021-03-23 7:11 上午
 * @Version 1.0
 **/
public class ComponentContextInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        ComponentContext context = new ComponentContext();
        context.init(servletContext);
//       servletContext.addListener(ComponentContextListener.class);
    }
}
