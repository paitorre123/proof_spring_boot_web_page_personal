package com.emanon.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.emanon.componentes.RequestTimedInterceptor;

@Configuration
public class WebMvcConfiguracion implements WebMvcConfigurer{
	
	@Autowired
	@Qualifier("requestTimedInterceptor")
	private RequestTimedInterceptor requestTimedInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimedInterceptor);
	}

	
	
}
