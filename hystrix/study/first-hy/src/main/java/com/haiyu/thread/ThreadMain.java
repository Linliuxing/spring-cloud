package com.haiyu.thread;

import com.netflix.config.ConfigurationManager;

/**
 * @author 林尤庆
 * @date 2018年4月19日 上午10:56:36
 * @version 1.0
 */
public class ThreadMain {
	public static void main(String[] args) throws Exception {
		ConfigurationManager.getConfigInstance().setProperty(
				"hystrix.threadpool.default.coreSize", 2);
		for(int i = 0; i < 6; i++) {
			MyCommand c = new MyCommand(i);
			c.queue();
		}
		Thread.sleep(5000);
	}


}
