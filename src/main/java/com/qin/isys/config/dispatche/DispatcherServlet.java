package com.qin.isys.config.dispatche;

import com.qin.isys.config.mvc.MvcConfig;
import com.qin.isys.config.spring.SpringConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

/**
 * dispatcherServlet configuration file.
 */
public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * spring配置文件
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringConfig.class};
    }

    /**
     * mvc配置文件
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    /**
     * 映射dispatcherServlet的路径为"/"
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置文件上传的目录到"/uploads/"
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("E:/IdeaProjects/isys/src/main/webapp/uploads",2*1024*1024,10*1024*1024,0));
    }

    /**
     * 给dispatcherServlet配置filter
     */
    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }
}
