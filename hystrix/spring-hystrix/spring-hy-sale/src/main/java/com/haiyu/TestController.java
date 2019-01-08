package com.haiyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 林尤庆
 * @date 2018年4月19日 上午11:26:17
 * @version 1.0
 */
@RestController
public class TestController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/router")
	public Member router() {
		return memberService.getMember(1);
	}

}

