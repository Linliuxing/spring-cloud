package com.haiyu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午7:54:31
 * @version 1.0
 */
@RestController
public class MyController {

	@GetMapping("/normalHello")
	public String normalHello() {
		return "Hello World";
	}


	@GetMapping("/errorHello")
	public String errorHello() throws Exception {
		Thread.sleep(10000);
		return "Error Hello World";
	}
}
