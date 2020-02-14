package com.isa.teachers.config;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import java.io.IOException;


@Stateless
public class TemplateProvider {

    private final String TEMPLATES_DIRECTORY_PATH = "WEB-INF/templates";

    private Configuration configuration;

    @EJB
    private ConfigProvider configProvider;

    public Template getTemplate(ServletContext servletContext, String templateName) throws IOException {

        configuration = configProvider.getConfiguration();
        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATES_DIRECTORY_PATH);
        return configuration.getTemplate(templateName);
    }
}
