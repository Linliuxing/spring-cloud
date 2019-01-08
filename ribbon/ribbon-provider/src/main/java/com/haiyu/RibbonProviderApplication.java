package com.haiyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class RibbonProviderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RibbonProviderApplication.class, args);
		Scanner scan = new Scanner(System.in);
		String port = scan.nextLine();
		new SpringApplicationBuilder(RibbonProviderApplication.class).properties("server.port=" + port).run(args);

	}

}

