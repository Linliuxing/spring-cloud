package com.haiyu.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 林尤庆
 * @date 2018年4月19日 下午5:11:39
 * @version 1.0
 */
@FeignClient(name = "spring-hy-member", fallback = HelloClientFallback.class)
public interface HelloClient {

	@GetMapping("/hello")
	public String hello();

	@GetMapping("/toHello")
	public String toHello();
}
