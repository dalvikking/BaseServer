package com.dalvik.application.server.deployer.resource;

import java.util.HashSet;
import java.util.Set;

public class ApplicationContext {

	private Set<IServiceContext> availableService;
	private Set<IServiceContext> utilService;

	public ApplicationContext() {
		availableService = new HashSet<>();
		utilService = new HashSet<>();
	}

	public Set<IServiceContext> getAvailableService() {
		return availableService;
	}

	public void setAvailableService(Set<IServiceContext> availableService) {
		this.availableService = availableService;
	}

	public Set<IServiceContext> getUtilService() {
		return utilService;
	}

	public void setUtilService(Set<IServiceContext> utilService) {
		this.utilService = utilService;
	}
}
