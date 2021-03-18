package org.geektimes.configuration.microprofile.config.Converters;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-03-18 2:55 下午
 * @Version 1.0
 **/
public class ClassConverter implements Converter<Class> {
    public static final Converter<Class> INSTANCE = new ClassConverter();
    @Override
    public Class convert(String value) {
        if(value == null) {
            return null;
        }
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader == null) {
                return Class.forName(value);
            }
            return Class.forName(value, true, loader);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}