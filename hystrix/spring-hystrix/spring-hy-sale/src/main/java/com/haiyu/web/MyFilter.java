package com.haiyu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * @author 林尤庆
 * @date 2018年4月19日 上午11:51:21
 * @version 1.0
 */
@WebFilter(urlPatterns = "/*", filterName = "hystrixFilter")
public class MyFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HystrixRequestContext ctx = HystrixRequestContext.initializeContext();
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			
		} finally {
			ctx.shutdown();
		}
	}

	public void destroy() {
		
	}

}

