package com.haiyu;

import org.springframework.web.bind.annotation.*;

/**
 * @author 林尤庆
 * @date 2018年4月19日 上午11:14:37
 * @version 1.0
 */
@RestController
public class MemberController {

	@GetMapping("/member/{id}")
	public Member call(@PathVariable Integer id) {
		Member p = new Member();
		p.setId(id);
		p.setName("jack");
		return p;
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/toHello")
	public String toHello() throws Exception {
		Thread.sleep(1000);
		return "timeout hello";
	}

}
