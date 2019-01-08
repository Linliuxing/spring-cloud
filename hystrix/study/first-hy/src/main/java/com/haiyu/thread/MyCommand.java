package com.haiyu.thread;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author 林尤庆
 * @date 2018年4月19日 上午10:55:20
 * @version 1.0
 */
public class MyCommand extends HystrixCommand<String> {
	
	private int index;

	public MyCommand(int index) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory
				.asKey("TestGroupKey")));
		this.index = index;
	}

	@Override
	protected String run() throws Exception {
		Thread.sleep(500);
		System.out.println("执行方法，当前索引：" + index);
		return "";
	}

	@Override
	protected String getFallback() {
		System.out.println("执行回退，当前索引：" + index);
		return "";
	}
	
	
}
