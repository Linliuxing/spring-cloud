package com.haiyu.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 林尤庆
 * @date 2018年4月20日 上午11:53:38
 * @version 1.0
 */
@Configuration
public class FilterConfig {

	@Bean
	public MyFilter myFilter() {
		return new MyFilter();
	}
}

