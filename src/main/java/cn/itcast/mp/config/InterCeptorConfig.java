package cn.itcast.mp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.itcast.mp.interceptor.AuthorizeInterceptor;

//@Configuration
public class InterCeptorConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		AuthorizeInterceptor interceptor = new AuthorizeInterceptor();
		registry.addInterceptor(interceptor);
	}	
}
