package com.dalvik.service.gateway.loadbalancer;

import com.dalvik.service.gateway.exception.LoadBalancerException;
import com.dalvik.service.gateway.resources.ServiceContext;

public interface ILoadBalancerAlgorithm {

	public ServiceContext getAvailableService() throws LoadBalancerException;

}
