package com.haiyu;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author 林尤庆
 * @date 2018年4月19日 下午5:53:10
 * @version 1.0
 */
public class TestMain {
	
	public static void main(String[] args) throws Exception {
		final CloseableHttpClient httpclient = HttpClients.createDefault();
		final String url = "http://localhost:8081/toHello";
		
		for(int i = 0; i < 6; i++) {
			Thread t = new Thread() {

				@Override
				public void run() {
					try {
						HttpGet httpget = new HttpGet(url);
						HttpResponse response = httpclient.execute(httpget);
						System.out.println(EntityUtils.toString(response.getEntity()));
					} catch (Exception e ) {
						e.printStackTrace();
					}
				}				
			};
			t.start();
		}
		Thread.sleep(15000);
	}

}
