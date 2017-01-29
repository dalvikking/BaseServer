package com.dalvik.application.server.deployer.resource;

import com.dalvik.application.server.deployer.exception.ServiceDeployException;

public interface IService {

	public void onInit(IServiceContext context) throws ServiceDeployException;

	public void onStart(IServiceContext context) throws ServiceDeployException;

	public void onStop(IServiceContext context) throws ServiceDeployException;

}
