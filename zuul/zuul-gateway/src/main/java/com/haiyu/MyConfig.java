package com.haiyu;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 林尤庆
 * @date 2018年4月20日 上午11:39:09
 * @version 1.0
 */
@Configuration
public class MyConfig {

	/**
	 * 访问网关的 /sale/**，将会被路由到 zuul-invoker 服务进行处理
	 */
	@Bean
	public PatternServiceRouteMapper patternServiceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(zuul)-(?<module>.+)", "${module}/**");
	}
}

