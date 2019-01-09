package com.haiyu;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author 林尤庆
 * @date 2018年4月21日 上午11:09:21
 * @version 1.0
 */
public class TestClient {
	
	public static void main(String[] args) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8081/refresh");
		HttpResponse response = client.execute(post);
		System.out.println(EntityUtils.toString(response.getEntity()));
	}

}
