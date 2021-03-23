package org.geektimes.configuration.microprofile.config.source.servlet;

import org.geektimes.configuration.microprofile.config.source.MapBasedConfigSource;

import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.Map;

public class ServletContextConfigSource extends MapBasedConfigSource {

    private    ServletContext servletContext;
    private  Map<String,String> configData;



    public ServletContextConfigSource(ServletContext servletContext) {
        super("ServletContext Init Parameters", 500);

            this.servletContext = servletContext;
            Enumeration<String> parameterNames = this.servletContext.getInitParameterNames();
            while (parameterNames.hasMoreElements()) {
                String parameterName = parameterNames.nextElement();
                configData.put(parameterName, this.servletContext.getInitParameter(parameterName));
            }
    }





    @Override
    protected void prepareConfigData(Map configData) throws Throwable {
      this.configData = configData;
    }
}
