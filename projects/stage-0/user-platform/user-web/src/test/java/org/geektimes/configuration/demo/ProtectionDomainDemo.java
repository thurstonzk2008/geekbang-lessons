package org.geektimes.configuration.demo;

import java.lang.reflect.Field;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Vector;

/**
 * TODO Comment
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since TODO
 * Date : 2021-04-24
 */
public class ProtectionDomainDemo {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Field field = ClassLoader.class.getDeclaredField("classes");
        field.setAccessible(true);
        // Bootstrap ClassLoader ( rt.jar in JDK ) 取不到
        Vector<Class> classes = (Vector<Class>) field.get(classLoader);
        for (Class klass : classes) {
            ProtectionDomain protectionDomain = klass.getProtectionDomain();
            CodeSource codeSource = protectionDomain.getCodeSource();
            System.out.printf("Class[%s] in %s\n", klass.getName(), codeSource.getLocation().getPath());
        }
    }
}
