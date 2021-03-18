package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OSenvPropertiesConfigSource implements ConfigSource {

    /*
    * 获取操作系统环境变量数据
     */
    String CONFIG_ORDINAL = "config_ordinal";
    int DEFAULT_ORDINAL = 200;

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

     @Override
     public int getOrdinal() {
        String configOrdinal = getValue(CONFIG_ORDINAL);
        if (configOrdinal != null) {
            try {
                return Integer.parseInt(configOrdinal);
            } catch (NumberFormatException ignored) {

            }
        }
        return DEFAULT_ORDINAL;
    }
}
