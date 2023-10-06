package com.dz.factory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("https://dz-team2-project-front-7uxma1hkz-svdjcuwg4638s-projects.vercel.app")
		.allowedMethods("*")
		.allowedHeaders("*")
		.allowCredentials(true);
	}
}
