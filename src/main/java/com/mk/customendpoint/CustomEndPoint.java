package com.mk.customendpoint;

import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
@Component
@Endpoint(id = "custom")
public class CustomEndPoint {

    @ReadOperation
    public String customEndpoint() {
        return "Hello from custom endpoint!";
    }
}
