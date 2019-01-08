package com.haiyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

/**
 * @author 林尤庆
 * @date 2018年4月9日 下午4:15:42
 * @version 1.0
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {
	
	@Autowired
	private MyHealthIndicator myHealthIndicator;

	public InstanceStatus getStatus(InstanceStatus currentStatus) {
		Status status = myHealthIndicator.health().getStatus();
		if(status.equals(Status.UP)){
			return InstanceStatus.UP;
		}else{
			return InstanceStatus.DOWN;
		}
	}

}
