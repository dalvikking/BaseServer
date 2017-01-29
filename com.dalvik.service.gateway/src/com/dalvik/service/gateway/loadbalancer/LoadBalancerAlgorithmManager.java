package com.dalvik.service.gateway.loadbalancer;

import java.util.HashMap;
import java.util.Map;

import com.dalvik.service.gateway.exception.LoadBalancerException;
/*
 * Register all the available LoadBalancing Algo here
 * Config file is used to determine which algo is to be used
 */
public class LoadBalancerAlgorithmManager {

	private static LoadBalancerAlgorithmManager instance;

	private Map<String, ILoadBalancerAlgorithm> loadBalancingAlgorithmMap;

	public static LoadBalancerAlgorithmManager getInstance() {

		synchronized (instance) {
			if (instance == null) {
				instance = new LoadBalancerAlgorithmManager();
			}
			return instance;
		}
	}

	private LoadBalancerAlgorithmManager() {
		loadBalancingAlgorithmMap = new HashMap<>();
	}

	public void registerAlgorithm(ILoadBalancerAlgorithm algorithm) throws LoadBalancerException {
	}

	public void unRegisterAlgorithm(ILoadBalancerAlgorithm algorithm) throws LoadBalancerException {
	}

}
