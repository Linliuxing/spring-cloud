package com.haiyu.contrat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * @author 林尤庆
 * @date 2018年4月13日 上午12:17:49
 * @version 1.0
 */
@Configuration
public class MyConfig {

	@Bean
	public Contract feignContract() {
		return new MyContract();
	}
}

