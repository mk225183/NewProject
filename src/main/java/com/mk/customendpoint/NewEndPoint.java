package com.mk.customendpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="newOne")
public class NewEndPoint {

	@ReadOperation
	public String test()
	{
		return "nwly created endpoint";
	}
}
