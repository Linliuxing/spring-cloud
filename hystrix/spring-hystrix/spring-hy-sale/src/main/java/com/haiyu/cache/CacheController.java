package com.haiyu.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 林尤庆
 * @date 2018年4月19日 上午11:55:49
 * @version 1.0
 */
@RestController
public class CacheController {
	
	@Autowired
	private CacheService cacheService;

	@GetMapping("/cache")
	public String cache() {
		for(int i = 0; i < 3; i++) {
			cacheService.cacheMember(1);
		}
		return "";
	}

	@GetMapping("/rc")
	public String testRemoveCache() {
		cacheService.getCache(1);
		cacheService.getCache(1);
		
		cacheService.removeCache(1);
		System.out.println("#########  分隔线   ###########");
		cacheService.getCache(1);
		return "";
	}
}

