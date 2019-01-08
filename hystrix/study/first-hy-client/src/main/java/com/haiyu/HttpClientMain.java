package com.haiyu;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午7:57:03
 * @version 1.0
 */
public class HttpClientMain {
	public static void main(String[] args) throws Exception {
		String url = "http://localhost:8080/normalHello";
		HttpGet httpget = new HttpGet(url);		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpResponse response = httpclient.execute(httpget);
		System.out.println(EntityUtils.toString(response.getEntity()));
	}

}
