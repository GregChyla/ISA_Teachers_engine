package com.isa.teachers.config;

import freemarker.core.PlainTextOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.ejb.Stateless;

@Stateless
public class ConfigProvider {
    private Configuration configuration;

    public Configuration getConfiguration() {

        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_29);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
            configuration.setOutputFormat(PlainTextOutputFormat.INSTANCE);
        }
        return configuration;
    }
}
