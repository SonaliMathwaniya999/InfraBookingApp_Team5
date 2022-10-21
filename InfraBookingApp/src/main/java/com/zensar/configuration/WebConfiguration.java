package com.zensar.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
	
			registry
							.addMapping("/api/**")
						.allowedMethods("GET","DELETE","PUT","OPTIONS")
						.allowedOrigins("http://localhost:4200");
		}
	}


