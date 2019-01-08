package com.haiyu.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;

/**
 * @author 林尤庆
 * @date 2018年4月20日 上午11:52:04
 * @version 1.0
 */
public class MyFilter extends ZuulFilter {
	
	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		System.out.println("执行 MyFilter 过滤器");
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
