package com.haiyu;

/**
 * @author 林尤庆
 * @date 2018年4月18日 下午8:01:45
 * @version 1.0
 */
public class NormalMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloCommand command = new HelloCommand();
		String result = command.execute();
		System.out.println(result);

	}

}
