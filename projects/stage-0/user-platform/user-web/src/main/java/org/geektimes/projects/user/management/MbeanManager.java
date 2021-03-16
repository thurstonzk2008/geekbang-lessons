package org.geektimes.projects.user.management;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-03-16 6:57 上午
 * @Version 1.0
 **/
public class MbeanManager {
    private static final MBeanServer M_BEAN_SERVER;
    static {
        M_BEAN_SERVER = ManagementFactory.getPlatformMBeanServer();
    }
    public static void registerMbean(Object mBeanObject,String mBeanObjectName ) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        M_BEAN_SERVER.registerMBean(mBeanObject,new ObjectName(mBeanObjectName));
    }
}
