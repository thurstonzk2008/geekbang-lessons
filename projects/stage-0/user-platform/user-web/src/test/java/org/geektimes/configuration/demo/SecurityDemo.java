package org.geektimes.configuration.demo;

/**
 * TODO Comment
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since TODO
 * Date : 2021-04-24
 */
public class SecurityDemo {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.setSecurityManager(new SecurityManager());
        System.setProperty("java.version", "1.7.0_1");
        System.out.println(System.getProperty("java.version"));
    }
}