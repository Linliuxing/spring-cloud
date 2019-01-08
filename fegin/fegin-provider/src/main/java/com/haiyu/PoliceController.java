package com.haiyu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author 林尤庆
 * @date 2018年3月15日 上午11:29:24
 * @version 1.0
 */
@RestController
public class PoliceController {

	@GetMapping("/call/{id}")
	public Police call(@PathVariable Integer id,HttpServletRequest request){
		Police p = new Police();
		p.setId(id);
		p.setName("jack");
		p.setMessage(request.getRequestURL().toString());
		return p;
	}

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello, " + name;
	}

	@GetMapping("/hellowd")
	public String helloWithOutArg() {
		return "Hello World";
	}
}
