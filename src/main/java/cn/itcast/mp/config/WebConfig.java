package cn.itcast.mp.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	  @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.addAllowedOrigin("*"); // 允许所有来源
	        config.addAllowedMethod("*"); // 允许所有方法（GET、POST等）
	        config.addAllowedHeader("*"); // 允许所有请求头
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
}

