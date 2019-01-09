package com.haiyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * 功能描述: 规则
 * 			/{application}/{profile}[/{label}]
 * 			/{application}-{profile}.yml
 * 			/{label}/{application}-{profile}.yml
 * 			/{application}-{profile}.properties
 * 			/{label}/{application}-{profile}.properties
 *
 * @param:
 * @return:
 * @auther: youqing
 * @date: 2019/1/8 18:51
 */

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
@RefreshScope
public class EurekaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigServerApplication.class, args);
	}

}

