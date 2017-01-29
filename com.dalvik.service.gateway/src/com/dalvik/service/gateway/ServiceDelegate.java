package com.dalvik.service.gateway;

import com.dalvik.service.gateway.discovery.IServiceDiscoveryManager;
import com.dalvik.service.gateway.discovery.ServiceDiscoveryManager;
import com.dalvik.service.gateway.resources.BaseResponse;

public class ServiceDelegate {

	private IServiceDiscoveryManager serviceDiscoveryManager;
	private String serviceType;

	public ServiceDelegate(String serviceType) {
		serviceDiscoveryManager = ServiceDiscoveryManager.getInstance();
		this.serviceType = serviceType;
	}

	public BaseResponse delegateServiceRequest() {

		// find service using discovery manager
		// then delegate request
		// write code for rest client here

		return null;
	}

}
