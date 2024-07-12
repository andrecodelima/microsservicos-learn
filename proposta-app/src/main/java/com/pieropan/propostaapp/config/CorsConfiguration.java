package com.pieropan.propostaapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")// concede permisao a tudo que vier depois de 'localhost/'
									.allowedOriginPatterns("http://localhost")
									.allowedMethods("*");// concede permissão a todos os métodos
	}
	
}
