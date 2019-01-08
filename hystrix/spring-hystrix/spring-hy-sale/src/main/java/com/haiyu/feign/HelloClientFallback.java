package com.haiyu.feign;

import org.springframework.stereotype.Component;

/**
 * @author 林尤庆
 * @date 2018年4月19日 下午5:12:26
 * @version 1.0
 */
@Component
public class HelloClientFallback implements HelloClient {

	public String hello() {
		return "fallback hello";
	}

	public String toHello() {
		return "fallback timeout hello";
	}

}