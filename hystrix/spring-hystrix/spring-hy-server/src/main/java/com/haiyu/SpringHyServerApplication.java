package com.haiyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringHyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHyServerApplication.class, args);
	}

}

