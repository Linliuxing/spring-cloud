package com.haiyu.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午8:26:27
 * @version 1.0
 */
public class TimeoutCommand extends HystrixCommand<String>{
	
	public TimeoutCommand() {
	    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Jack"))
	            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
	                   .withExecutionTimeoutInMilliseconds(2000)));
	}

	@Override
	protected String run() throws Exception {
		Thread.sleep(1000);
		System.out.println("执行命令");
		return "success";
	}

	@Override
	protected String getFallback() {
		System.out.println("执行回退方法");
		return "fallback";
	}
	

}
