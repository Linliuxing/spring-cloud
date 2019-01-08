package com.haiyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

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
		String json = tpl.getForObject("http://ribbon-provider/call/1", String.class);
		return json;
	}
	
	@Autowired
	private LoadBalancerClient client;

	@GetMapping("/lb")
	@ResponseBody
	public ServiceInstance lb(){
		ServiceInstance si = client.choose("ribbon-provider");
		return si;
	}
	
	@Autowired
	private SpringClientFactory factory;

	@GetMapping("/fa")
	public String factory(){
		ZoneAwareLoadBalancer i =(ZoneAwareLoadBalancer) factory.getLoadBalancer("default");
		System.out.println(i.getRule().getClass().getName());
		
		ZoneAwareLoadBalancer i2 =(ZoneAwareLoadBalancer) factory.getLoadBalancer("ribbon-provider");
		System.out.println(i2.getRule().getClass().getName());
		
		return "";
	}
}
