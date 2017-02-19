package com.qin.isys.config.servlet;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * servlet and filter configuration.
 */
public class ServletInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
//        ServletRegistration.Dynamic servletRegistration=servletContext.addServlet("myServlet",MyServlet.class);
//        servlet.addMapping("/web/test");
//
//        FilterRegistration.Dynamic filterRegistration=servletContext.addFilter("myFilter",MyFilter.class);
//        filter.addMappingForUrlPatterns(null,false,"/web/test");

    }
}
