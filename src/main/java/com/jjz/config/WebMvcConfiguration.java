package com.jjz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Spring MVC {@link Configuration}. Extends {@link WebMvcConfigurationSupport}, which provides convenient callbacks that allow
 * customization of aspects of the Spring Web MVC framework. Callbacks allow registering custom interceptors, message converters, argument
 * resolvers, a validator, resource handling, etc.
 */
@Configuration
// @EnableCaching
// @ImportResource("classpath:services.xml")
@ComponentScan(basePackages = { "com.jjz" }, includeFilters = @ComponentScan.Filter({ Controller.class }), excludeFilters = @ComponentScan.Filter({ Configuration.class }))
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	Logger logger = LoggerFactory.getLogger(getClass());

	public WebMvcConfiguration() {
		logger.info("init");
	}
}
