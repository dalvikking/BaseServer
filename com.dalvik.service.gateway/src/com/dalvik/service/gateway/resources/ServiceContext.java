package com.dalvik.service.gateway.resources;

public class ServiceContext implements IServiceContext {

	private ServiceState currentState;
	private Host serviceHost;
	private String servicePath;

	public ServiceContext() {
		Host host = new Host();
		serviceHost = host;
		currentState = ServiceState.INITIALIZING;
	}

	@Override
	public ServiceState getServiceState() {
		return currentState;
	}

	@Override
	public Host getHost() {
		return serviceHost;
	}

	public void setHost(Host host) {
		serviceHost = host;
	}

	public void setServicePath(String path) {
		servicePath = path;
	}

	@Override
	public String getServicePath() {
		return servicePath;
	}

	@Override
	public void changeState(ServiceState state) {
		if (state != null && state.equals(currentState)) {
			currentState = state;
		}
	}

}
