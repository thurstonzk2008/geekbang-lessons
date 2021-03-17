package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;
import org.geektimes.context.ComponentContext;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesFilesConfigSource implements ConfigSource {

    /*
    * 从properties文件中获取配置
     */
    private final Map<String, String> properties;
    private final String CONFIG_FILE_NAME = "/META-INF/application.properties";
    private static final Logger logger = Logger.getLogger(PropertiesFilesConfigSource.class.getName());

    public PropertiesFilesConfigSource() {
        //从JNDI中查找配置文件的路径
        ComponentContext context = ComponentContext.getInstance();
        String configFile = context.lookupComponent("configFile");

        Properties pps = new Properties();
        InputStream in = null;
        try {
            String configFileInput = (configFile==null|"".equals(configFile))?CONFIG_FILE_NAME:configFile;
            Thread.currentThread().getContextClassLoader().getResourceAsStream(configFileInput);
            pps.load(in);
            this.properties = new HashMap(pps);
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

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
        return "Files Properties";
    }
}
