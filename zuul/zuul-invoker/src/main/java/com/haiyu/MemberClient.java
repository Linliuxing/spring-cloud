package com.haiyu;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 林尤庆
 * @date 2018年4月20日 上午10:27:19
 * @version 1.0
 */
@FeignClient("zuul-provider")
public interface MemberClient {

	@GetMapping("/member/{id}")
	public Member getMember(@PathVariable("id") Integer id);
}
