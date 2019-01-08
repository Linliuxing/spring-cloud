package com.haiyu.cb;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午8:36:18
 * @version 1.0
 */
public class FallbackMain {
	public static void main(String[] args) {
		FallbackCommand c = new FallbackCommand();
		String result = c.execute();
		System.out.println(result);
	}

	static class FallbackCommand extends HystrixCommand<String> {
		
		public FallbackCommand() {
		    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
		            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
		                  .withCircuitBreakerForceOpen(true)));
		}

		@Override
		protected String run() throws Exception {
			return "success";
		}

		@Override
		protected String getFallback() {
			return "fallback";
		}
	}

}
