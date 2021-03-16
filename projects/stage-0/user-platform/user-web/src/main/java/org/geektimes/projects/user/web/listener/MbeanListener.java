package org.geektimes.projects.user.web.listener;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.management.MbeanManager;
import org.geektimes.projects.user.management.UserManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

/**
 *  Mbean监听器
 */
public class MbeanListener implements ServletContextListener {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String mBeanObjectName = "org.geektimes.projects.user.management:type=User";

        User testUser = new User();
        testUser.setId(100L);
        testUser.setName("testUser");
        testUser.setEmail("testEmail@163.com");
        try {
            MbeanManager.registerMbean(new UserManager(testUser),mBeanObjectName);
            logger.info("testUser Mbean 注册完成");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
