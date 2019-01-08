package com.haiyu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 读取控制台的端口输入
		String port = scan.nextLine();
		new SpringApplicationBuilder(ProviderApp.class).properties("server.port=" + port).run(args);
	}

}

