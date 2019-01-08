package com.haiyu;

import org.springframework.web.bind.annotation.*;

/**
 * @author 林尤庆
 * @date 2018年4月20日 上午11:37:35
 * @version 1.0
 */
@RestController
public class TestController {

	@GetMapping("/source/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		return "hello " + name;
	}
}

