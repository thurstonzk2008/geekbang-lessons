package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OSenvPropertiesConfigSource implements ConfigSource {

    /*
    * 获取操作系统环境变量数据
     */
    private final Map<String, String> properties;

    public OSenvPropertiesConfigSource() {
        properties = System.getenv();
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "OS Env Properties";
    }
}
