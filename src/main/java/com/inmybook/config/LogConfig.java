package com.inmybook.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmybook.common.LogFilter;

@Configuration
public class LogConfig {

	@Bean
	public FilterRegistrationBean<LogFilter> logFilter() {
		FilterRegistrationBean<LogFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new LogFilter());
		filterRegistrationBean.addUrlPatterns("/*");

		return filterRegistrationBean;
	}
}
