package com.haiyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ZuulInvokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulInvokerApplication.class, args);
	}

}

