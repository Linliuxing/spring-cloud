package com.haiyu;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author 林尤庆
 * @date 2018年4月9日 下午3:54:51
 * @version 1.0 
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

	public Health health() {
		if(PoliceController.canvisitdb){
			return new Health.Builder(Status.UP).build();
		}else{
			return new Health.Builder(Status.DOWN).build();
		}
	}

}
