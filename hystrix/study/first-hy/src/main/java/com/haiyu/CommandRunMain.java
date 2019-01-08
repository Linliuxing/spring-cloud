package com.haiyu;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import rx.Observable;
import rx.Observer;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午8:18:34
 * @version 1.0
 */
public class CommandRunMain {

	public static void main(String[] args) throws Exception {
		RunCommand c1 = new RunCommand("observe method");
		c1.observe();

		RunCommand c2 = new RunCommand("toObservable method");
		Observable ob = c2.toObservable();
		ob.subscribe(new Observer<String>() {

			public void onCompleted() {
				System.out.println("command completed");
			}

			public void onError(Throwable e) {

			}

			public void onNext(String t) {
				System.out.println("###" + t);
			}

		});

		Thread.sleep(1000);
	}

	static class RunCommand extends HystrixCommand<String> {

		String msg;

		public RunCommand(String msg) {
			super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
			this.msg = msg;
		}

		@Override
		protected String run() throws Exception {
			System.out.println(msg);
			return "success";
		}
	}

}
