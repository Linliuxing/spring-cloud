package com.haiyu;

import com.haiyu.contrat.MyUrl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 林尤庆
 * @date 2018年4月13日 上午12:11:03
 * @version 1.0
 */
@FeignClient("fegin-provider")
public interface HelloClient {
	
	@RequestMapping(method = RequestMethod.GET, value="/hello/{name}")
	String hello(@PathVariable("name") String name);
	
	
	@RequestMapping(method = RequestMethod.GET, value="/call/{id}")
	Police getPolice(@PathVariable("id") Integer id);
	
	@MyUrl(url = "/hellowd", method = "GET")
	String myHello();
	

}
