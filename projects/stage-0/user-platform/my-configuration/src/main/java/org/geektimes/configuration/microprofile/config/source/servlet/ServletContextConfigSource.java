package org.geektimes.configuration.microprofile.config.source.servlet;

import org.geektimes.configuration.microprofile.config.source.MapBasedConfigSource;

import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.Map;

import static java.lang.String.format;

public class ServletContextConfigSource extends MapBasedConfigSource {

    private final ServletContext servletContext;
    private Map<String, String> data;

    public ServletContextConfigSource(ServletContext servletContext) {
        super(format("ServletContext[path:%s] Init Parameters", servletContext.getContextPath()), 500);
        this.servletContext = servletContext;
        Enumeration<String> parameterNames = servletContext.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            data.put(parameterName, servletContext.getInitParameter(parameterName));
        }
    }

    @Override
    protected void prepareConfigData(Map configData) throws Throwable {
        data = configData;

    }
}
