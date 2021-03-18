package org.geektimes.configuration.microprofile.config;


import com.sun.javafx.css.converters.DurationConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigValue;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.Converter;
import org.geektimes.configuration.microprofile.config.Converters.ClassConverter;
import org.geektimes.configuration.microprofile.config.Converters.IntegerConverter;
import org.geektimes.configuration.microprofile.config.Converters.StringConverter;

import java.lang.reflect.Type;

import java.util.*;

public class JavaConfig implements Config {

    /**
     * 内部可变的集合，不要直接暴露在外面
     */
    private List<ConfigSource> configSources = new LinkedList<>();
    Map<Type, Converter> converters = new HashMap<>();

    private static Comparator<ConfigSource> configSourceComparator = new Comparator<ConfigSource>() {
        @Override
        public int compare(ConfigSource o1, ConfigSource o2) {
            return Integer.compare(o2.getOrdinal(), o1.getOrdinal());
        }
    };

    public JavaConfig() {
        ClassLoader classLoader = getClass().getClassLoader();
        ServiceLoader<ConfigSource> serviceLoader = ServiceLoader.load(ConfigSource.class, classLoader);
        serviceLoader.forEach(configSources::add);
        // 排序
        configSources.sort(configSourceComparator);
        //加载转换器
        ServiceLoader<Converter> converterServiceLoader = ServiceLoader.load(Converter.class, classLoader);
        registerDefaultConverter();
    }
    private void registerDefaultConverter() {
        converters.put(String.class, StringConverter.INSTANCE);
        converters.put(Integer.class, IntegerConverter.INSTANCE);
        converters.put(int.class, IntegerConverter.INSTANCE);
        converters.put(Class.class, ClassConverter.INSTANCE);

    }

    @Override
    public <T> T getValue(String propertyName, Class<T> propertyType) {
        String propertyValue = getPropertyValue(propertyName);
        // String 转换成目标类型
        return convert(propertyValue, propertyType);
    }
    public <T> T convert(String value, Class<T> asType) {
        if (value != null) {
            Optional<Converter<T>> converter = getConverter(asType);
            if (converter.isPresent()){
                return converter.get().convert(value);
            }
        }

        return null;
    }

    @Override
    public ConfigValue getConfigValue(String propertyName) {
        return null;
    }

    protected String getPropertyValue(String propertyName) {
        String propertyValue = null;
        for (ConfigSource configSource : configSources) {
            propertyValue = configSource.getValue(propertyName);
            if (propertyValue != null) {
                break;
            }
        }
        return propertyValue;
    }

    @Override
    public <T> Optional<T> getOptionalValue(String propertyName, Class<T> propertyType) {
        T value = getValue(propertyName, propertyType);
        return Optional.ofNullable(value);
    }

    @Override
    public Iterable<String> getPropertyNames() {
        return null;
    }

    @Override
    public Iterable<ConfigSource> getConfigSources() {
        return Collections.unmodifiableList(configSources);
    }

    @Override
    public <T> Optional<Converter<T>> getConverter(Class<T> forType) {
        Converter converter = converters.get(forType);

        if (converter == null) {
            throw new RuntimeException("No Converter registered for class " + forType);
        }
        return Optional.ofNullable(converter);
    }

    @Override
    public <T> T unwrap(Class<T> type) {
        return null;
    }
}
