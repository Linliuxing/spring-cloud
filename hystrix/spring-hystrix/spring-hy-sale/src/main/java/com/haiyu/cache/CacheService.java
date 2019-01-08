package com.haiyu.cache;


import com.haiyu.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

/**
 * @author 林尤庆
 * @date 2018年4月19日 上午11:47:26
 * @version 1.0
 */
@Service
public class CacheService {
	
	@Autowired
	private RestTemplate restTpl;
	
	@CacheResult
	@HystrixCommand
	public Member cacheMember(Integer id) {
		System.out.println("调用 cacheMember 方法");
		Member member = restTpl.getForObject(
				"http://spring-hy-member/member/{id}", Member.class, id);
		return member;
	}
	
	@CacheResult
	@HystrixCommand(commandKey = "cacheKey")
	public String getCache(Integer id) {
		System.out.println("执行查询方法");
		return null;
	}
	
	@CacheRemove(commandKey = "cacheKey")
	@HystrixCommand
	public void removeCache(Integer id) {
		System.out.println("删除缓存方法");
	}

}
