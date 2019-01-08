package com.haiyu.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;

/**
 * @author 林尤庆
 * @date 2018年4月19日 下午5:14:25
 * @version 1.0
 */

@RestController
public class FeignController {
	
	@Autowired
	private HelloClient helloClient;

	@GetMapping("/hello")
	public String hello() {
		String str = helloClient.hello();
		System.out.println(str);
		return str;
	}

	@GetMapping("/toHello")
	public String toHello() {
		String result = helloClient.toHello();
		HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
				.getInstance(HystrixCommandKey.Factory
						.asKey("HelloClient#toHello()"));	
		System.out.println("断路器状态：" + breaker.isOpen());
		return result;
	}
}
