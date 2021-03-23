package org.geektimes.dependency.injection.context;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * ComponentContext初始化
 *
 * @author zhuhk
 * @create 2021-03-23 6:59 上午
 * @Version 1.0
 * @see javax.servlet.ServletContainerInitializer
 **/
@WebListener
public class ComponentContextListener implements ServletContextListener {
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.servletContext = servletContextEvent.getServletContext();
        ComponentContext context = new ComponentContext();
        context.init(servletContext);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
