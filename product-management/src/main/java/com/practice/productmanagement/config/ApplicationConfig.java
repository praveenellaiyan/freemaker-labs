/**
 * 
 */
package com.practice.productmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * @author Praveen Ellaiyan
 *
 */
@Configuration
public class ApplicationConfig {

	private final static String PREFIX = "";
	private final static String SUFFIX = ".ftl";
	private final static String ENCODING = "UTF-8";
	private final static String TEMPLATE_PATH = "classpath:/templates";

	@Bean
	public FreeMarkerViewResolver freemarkerViewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setCache(true);
		resolver.setPrefix(PREFIX);
		resolver.setSuffix(SUFFIX);
		return resolver;
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath(TEMPLATE_PATH);
		freeMarkerConfigurer.setDefaultEncoding(ENCODING);
		return freeMarkerConfigurer;
	}

}
