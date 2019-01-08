package com.haiyu.collapser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import com.haiyu.Member;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


/**
 * @author 林尤庆
 * @date 2018年4月19日 下午12:14:52
 * @version 1.0
 */
@Service
public class CollService {

	@HystrixCollapser(batchMethod = "getMembers", collapserProperties = {
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")
	})
	public Future<Member> getMember(Integer id) {
		System.out.println("执行单个查询的方法");
		return null;
	}
	
	@HystrixCommand
	public List<Member> getMembers(List<Integer> ids) {
		List<Member> mems = new ArrayList<Member>();
		for(Integer id : ids) {
			System.out.println(id);
			Member m = new Member();
			m.setId(id);
			m.setName("Jack");
			mems.add(m);
		}
		return mems;
	}
}
