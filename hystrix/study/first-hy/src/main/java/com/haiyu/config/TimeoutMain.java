package com.haiyu.config;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午8:29:24
 * @version 1.0
 */
public class TimeoutMain {
	
	public static void main(String[] args) {
		TimeoutCommand c = new TimeoutCommand();
		String result = c.execute();
		System.out.println(result);
	}

}
