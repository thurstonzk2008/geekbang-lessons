package org.geektimes.configuration.microprofile.config.Converters;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-03-18 2:57 下午
 * @Version 1.0
 **/
public class StringConverter implements Converter<String> {

    public static final StringConverter INSTANCE = new StringConverter();

    @Override
    public String convert(String value) {
        return value;
    }
}
