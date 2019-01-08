package com.haiyu;

import org.springframework.web.bind.annotation.*;

/**
 * @author 林尤庆
 * @date 2018年3月15日 上午11:29:24
 * @version 1.0
 */
@RestController
public class MemberController {

	@GetMapping("/member/{id}")
	public Member call(@PathVariable Integer id){
		Member member = new Member();
		member.setId(id);
		member.setName("jack");
		return member;
	}
}
