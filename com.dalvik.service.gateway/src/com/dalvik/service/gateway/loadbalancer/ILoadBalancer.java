package com.dalvik.service.gateway.loadbalancer;

import com.dalvik.service.gateway.exception.LoadBalancerException;
import com.dalvik.service.gateway.resources.IServiceContext;

/*
 * Very basic implementation of load balancer
 * which can use any algo to balance the load between 
 * multiple instances of same microservice
 * provided multliple instance are up and running
 */
public interface ILoadBalancer {

	public IServiceContext executeAlgorithm(ILoadBalancerAlgorithm algorithm) throws LoadBalancerException;

}
