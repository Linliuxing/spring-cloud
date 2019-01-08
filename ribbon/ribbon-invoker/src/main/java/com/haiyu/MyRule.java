package com.haiyu;

import java.util.List;
import java.util.Random;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * @author 林尤庆
 * @date 2018年4月9日 下午6:26:14
 * @version 1.0
 */
public class MyRule implements IRule {
	
	private ILoadBalancer lb;

	public Server choose(Object key) {
		Random r= new Random();
		int num = r.nextInt(10);
		
		List<Server> servers =  lb.getAllServers();
		
		if(num > 7){
			return getServerByPost(servers,8081);
		}else{
			return getServerByPost(servers,8080);
		}
		
	}
	
	private Server getServerByPost(List<Server> servers,int port){
		for(Server s:servers){
			if(s.getPort() == port){
				return s;
			}
		}
		return null;
	}

	public void setLoadBalancer(ILoadBalancer lb) {
		this.lb=lb;
		
	}

	public ILoadBalancer getLoadBalancer() {
		return this.lb;
	}

}
