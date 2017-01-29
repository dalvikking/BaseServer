package com.dalvik.service.gateway.resources;

public interface IServiceContext {

	public ServiceState getServiceState();

	public Host getHost();

	public void changeState(ServiceState state);

	public String getServicePath();

}
