package org.geektimes.configuration.microprofile.config.Converters;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * TODO
 *
 * @author zhuhk
 * @create 2021-03-18 3:24 下午
 * @Version 1.0
 **/
    public class IntegerConverter implements Converter<Integer> {

        public static final IntegerConverter INSTANCE = new IntegerConverter();

        @Override
        public Integer convert(String value) {
            return value != null ? Integer.valueOf(value) : null;
        }
    }
