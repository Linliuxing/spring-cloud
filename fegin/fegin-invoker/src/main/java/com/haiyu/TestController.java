package com.haiyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 林尤庆
 * @date 2018年3月15日 上午11:51:37
 * @version 1.0
 */
@RestController
public class TestController {
	
	@Autowired
	private HelloClient helloClient;

	@GetMapping("/router")
	public String router() {
		String result = helloClient.hello("jack");
		return result;
	}

	@GetMapping("/police")
	public Police getPolice() {
		Police p = helloClient.getPolice(1);
		return p;
	}

	@GetMapping("/myhello")
	public String myHello() {
		return helloClient.myHello();
	}

}
