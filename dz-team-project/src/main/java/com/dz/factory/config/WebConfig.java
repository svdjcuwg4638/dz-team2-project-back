package com.dz.factory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("https://dz-team2-project-front.vercel.app")
		.allowedMethods("*")
		.allowedHeaders("*")
		.allowCredentials(true);
	}
}
