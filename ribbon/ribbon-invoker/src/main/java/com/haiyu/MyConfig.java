package com.haiyu;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;

/**
 * @author 林尤庆
 * @date 2018年4月10日 下午7:28:35
 * @version 1.0
 */
public class MyConfig {
	
	@Bean
	public IRule getRule(){
		return new MyRule();
	}

}
