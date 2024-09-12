package com.mk.customendpoint;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyDbHeath implements HealthIndicator{

	
	public boolean test()
	{
		return false;
	}
	@Override
	public Health health() {
		if(test())
		{
			return Health.up().withDetail("DB service", "serivce is running").build();
		}
		return Health.down().withDetail("DB service", "serivce is down").build();
	}

}
