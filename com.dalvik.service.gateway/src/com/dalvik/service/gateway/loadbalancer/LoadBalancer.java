package com.dalvik.service.gateway.loadbalancer;

import com.dalvik.service.gateway.exception.LoadBalancerException;
import com.dalvik.service.gateway.listeners.ServiceRegisteredListener;
import com.dalvik.service.gateway.listeners.ServiceUnRegisteredListener;
import com.dalvik.service.gateway.resources.IServiceContext;

public class LoadBalancer implements ILoadBalancer, ServiceRegisteredListener, ServiceUnRegisteredListener {

	private static LoadBalancer instance;

	public static LoadBalancer getInstance() {
		if (instance == null) {
			synchronized (LoadBalancer.class) {
				instance = new LoadBalancer();
			}
		}
		return instance;
	}

	private LoadBalancer() {

		// fetch available service from registry

	}

	@Override
	public IServiceContext executeAlgorithm(ILoadBalancerAlgorithm algorithm) throws LoadBalancerException {

		// wtite Algo execution code here
		return null;
	}

	@Override
	public void onUnregister(IServiceContext context) {

		// update load balancer local available service list

	}

	@Override
	public void onRegister(IServiceContext context) {

		// update load balancer local available service list

	}

}
