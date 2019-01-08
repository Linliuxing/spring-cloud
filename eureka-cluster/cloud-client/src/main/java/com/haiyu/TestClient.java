package com.haiyu;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author 林尤庆
 * @date 2018年3月15日 下午1:19:39
 * @version 1.0
 */
public class TestClient {

	public static void main(String[] args) throws Exception {
		// 创建默认的HttpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 调用6次服务并输出结果
		for(int i = 0; i < 6; i++) {
			// 调用 GET 方法请求服务
			HttpGet httpget = new HttpGet("http://localhost:9000/router");
			// 获取响应
			HttpResponse response = httpclient.execute(httpget);
			// 根据 响应解析出字符串
			System.out.println(EntityUtils.toString(response.getEntity()));
		}
	}

}
