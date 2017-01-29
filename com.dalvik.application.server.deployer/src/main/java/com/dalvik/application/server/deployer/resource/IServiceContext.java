package com.dalvik.application.server.deployer.resource;

public interface IServiceContext {

	public ServiceState getServiceState();

	public Host getHost();

	public void changeState(ServiceState state);

	public String getServicePath();

}
