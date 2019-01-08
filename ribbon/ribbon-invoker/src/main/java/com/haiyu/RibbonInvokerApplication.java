package com.haiyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonInvokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonInvokerApplication.class, args);
	}

}

