package com.haiyu;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午8:00:12
 * @version 1.0
 */
public class HelloCommand extends HystrixCommand<String> {
	
	public HelloCommand() {
		super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
	}

	protected String run() throws Exception {
		String url = "http://localhost:8080/normalHello";
		HttpGet httpget = new HttpGet(url);		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpResponse response = httpclient.execute(httpget);
		return EntityUtils.toString(response.getEntity());
	}
	
	protected String getFallback() {
		System.out.println("fall back method");
		return "fall back hello";
	}

}
