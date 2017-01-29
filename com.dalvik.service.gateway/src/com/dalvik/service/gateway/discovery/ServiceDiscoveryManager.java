package com.dalvik.service.gateway.discovery;

public class ServiceDiscoveryManager implements IServiceDiscoveryManager {

	private static ServiceDiscoveryManager instance;

	public static ServiceDiscoveryManager getInstance() {
		if (instance == null) {
			synchronized (ServiceDiscoveryManager.class) {
				instance = new ServiceDiscoveryManager();
			}
		}
		return instance;
	}

	private ServiceDiscoveryManager() {
	}

}
