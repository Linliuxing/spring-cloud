package com.haiyu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author 林尤庆
 * @date 2018年3月15日 上午11:51:37
 * @version 1.0
 */
@Controller
@Configuration
public class TestController {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@GetMapping("/router")
	@ResponseBody
	public String router() {
		RestTemplate tpl = getRestTemplate();
		String json = tpl.getForObject("http://first-police/call/1", String.class);
		return json;
	}

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/list")
	@ResponseBody
	public String serviceCount(){
		List<String> names = discoveryClient.getServices();
		for(String serviceId : names){
			List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
			System.out.println(serviceId+" : "+instances.size());
		}
		return "";
	}
}
