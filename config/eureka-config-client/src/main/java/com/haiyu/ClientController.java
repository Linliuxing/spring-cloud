package com.haiyu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 林尤庆
 * @date 2018年4月21日 上午10:16:55
 * @version 1.0
 */
@RestController
public class ClientController {

	@Value("${haiyu.hello}")
	private String hello;

	@RequestMapping("/hello")
	public String from() {
		return this.hello;
	}
}

