package com.haiyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 林尤庆
 * @date 2018年3月15日 上午11:51:37
 * @version 1.0
 */
@RestController
public class TestController {
	
	@Autowired
	private MemberClient memberClient;

	@GetMapping("/food-sale/{memberId}")
	public String foodSale(@PathVariable Integer memberId) {
		Member m = memberClient.getMember(memberId);
		System.out.println(m.getId() + "---" + m.getName());
		return "success";
	}

}

