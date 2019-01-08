package com.haiyu;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

/**
 * @author 林尤庆
 * @date 2018年4月12日 上午10:17:42
 * @version 1.0
 */
public class MyRequest implements HttpRequest {
	
	HttpRequest sourceRequest;

	@Override
	public String getMethodValue() {
		return null;
	}

	public MyRequest(HttpRequest sourceRequest) {
		this.sourceRequest = sourceRequest;
	}

	public HttpHeaders getHeaders() {
		return sourceRequest.getHeaders();
	}

	public HttpMethod getMethod() {
		return sourceRequest.getMethod();
	}

	public URI getURI() {
		try {
			URI newUri = new URI("http://localhost:8080/hello");
			return newUri;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceRequest.getURI();
	}

}

