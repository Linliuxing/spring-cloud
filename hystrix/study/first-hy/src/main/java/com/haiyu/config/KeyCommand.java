package com.haiyu.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午8:32:24
 * @version 1.0
 */
public class KeyCommand extends HystrixCommand<String> {
	public KeyCommand() {
		super(
				Setter.withGroupKey(
						HystrixCommandGroupKey.Factory.asKey("TestGroupKey"))
						.andCommandKey(HystrixCommandKey.Factory.asKey("CommandKey"))
						.andThreadPoolKey(
								HystrixThreadPoolKey.Factory.asKey("PoolKey")));
	}

	@Override
	protected String run() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
