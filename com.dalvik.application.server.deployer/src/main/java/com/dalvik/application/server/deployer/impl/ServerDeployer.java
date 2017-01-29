package com.dalvik.application.server.deployer.impl;

import com.dalvik.application.server.deployer.exception.ServerDeployException;
import com.dalvik.application.server.deployer.exception.ServiceDeployException;
import com.dalvik.application.server.deployer.resource.ApplicationContext;
import com.dalvik.application.server.deployer.resource.IServiceContext;
import com.dalvik.application.server.deployer.resource.Service;

public class ServerDeployer implements IServerDeployer {

	private static ServerDeployer instance = null;

	public static IServerDeployer getInstance() {
		if (instance == null) {
			instance = new ServerDeployer();
		}
		return instance;
	}

	@Override
	public void onInit(ApplicationContext context) throws ServerDeployException {
		// Deploy Service Registry Here
		// Deploy Service Discovery Here
		// Deploy LoadBalancer Here
		// Deploy Health Monitor Here
		// Deploy Auth Service Here

		try {
			for (IServiceContext serviceContext : context.getUtilService()) {
				startService(serviceContext);
			}
		} catch (ServiceDeployException e) {
			throw new ServerDeployException(e.getMessage());
		}
	}

	private void startService(IServiceContext serviceContext) throws ServiceDeployException {

		Service service = new Service();
		try {
			// init service
			service.onInit(serviceContext);
			// start service
			service.onStart(serviceContext);
		} catch (ServiceDeployException e) {
			throw new ServiceDeployException(e.getMessage());
		}

	}

	@Override
	public void onStart(ApplicationContext context) throws ServerDeployException {
		// Deploy Configured Business Logic Service Here
		try {
			for (IServiceContext serviceContext : context.getAvailableService()) {
				startService(serviceContext);
			}
		} catch (ServiceDeployException e) {
			throw new ServerDeployException(e.getMessage());
		}
	}

	@Override
	public void onStop(ApplicationContext context) throws ServerDeployException {
		// Clean all resource here
	}

}
