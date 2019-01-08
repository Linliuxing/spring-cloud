package com.haiyu.config;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午8:33:56
 * @version 1.0
 */
public class PropertyMain {
	
	public static void main(String[] args) {
		ConfigurationManager
		.getConfigInstance()
		.setProperty(
				"hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
				2000);
		PropertyCommand c = new PropertyCommand();
		String result = c.execute();
		System.out.println(result);
	}

	static class PropertyCommand extends HystrixCommand<String> {
		public PropertyCommand() {
		    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")));
		}

		@Override
		protected String run() throws Exception {
			Thread.sleep(3500);
			return "success";
		}

		@Override
		protected String getFallback() {
			return "fallback";
		}
		
	}

}
