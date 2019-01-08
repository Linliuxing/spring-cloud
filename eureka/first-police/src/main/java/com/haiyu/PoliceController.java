package com.haiyu;

import org.springframework.web.bind.annotation.*;

/**
 * @author 林尤庆
 * @date 2018年3月15日 上午11:29:24
 * @version 1.0
 */
@RestController
public class PoliceController {

	@GetMapping("/call/{id}")
	public Police call(@PathVariable Integer id){
		Police p = new Police();
		p.setId(id);
		p.setName("angus");
		return p;
	}
}
