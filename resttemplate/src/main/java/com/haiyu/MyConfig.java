package com.haiyu;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 * @author 林尤庆
 * @date 2018年4月10日 下午8:34:41
 * @version 1.0
 */
@Configuration
public class MyConfig {
	
	@Autowired(required = false)
	@MyLoadBalancer
	private List<RestTemplate> tpls = Collections.emptyList();
	
	@Bean
	public SmartInitializingSingleton IbInitializing(){
		return new SmartInitializingSingleton(){

			public void afterSingletonsInstantiated() {
				for(RestTemplate tpl : tpls) {
					List<ClientHttpRequestInterceptor> interceptors = tpl.getInterceptors();
					interceptors.add(new MyInterceptor());
					tpl.setInterceptors(interceptors);
				}
				
			}
			
		};
	}

}
