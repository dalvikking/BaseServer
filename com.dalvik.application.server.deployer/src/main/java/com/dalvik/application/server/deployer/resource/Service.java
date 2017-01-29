package com.dalvik.application.server.deployer.resource;

import com.dalvik.application.server.deployer.exception.ServiceDeployException;
import com.dalvik.tomcat.exception.WebAppDeployerException;
import com.dalvik.tomcat.impl.MicroServiceDeployer;

public class Service extends AbstractService {

	@Override
	public void onInit(IServiceContext context) throws ServiceDeployException {
		context.changeState(ServiceState.INITIALIZING);
		// register service here for discovery
		// init DB and Tables
	}

	@Override
	public void onStart(IServiceContext context) throws ServiceDeployException {
		context.changeState(ServiceState.STARTING);
		// Deploy Application war here using embedded Tomcat
		deployService(context);
		context.changeState(ServiceState.RUNNING);
	}

	private void deployService(IServiceContext context) throws ServiceDeployException {

		try {
			MicroServiceDeployer.getInstance().deploy(Integer.valueOf(context.getHost().getHostPort()),
					"/" + context.getHost().getHostName(), context.getServicePath());
			MicroServiceDeployer.getInstance().start();
		} catch (NumberFormatException | WebAppDeployerException e) {
			throw new ServiceDeployException(e.getMessage());
		}
	}

	@Override
	public void onStop(IServiceContext context) throws ServiceDeployException {
		context.changeState(ServiceState.STOPING);
		// unregister service here
		// Stop Tomcat here
		context.changeState(ServiceState.STOPPED);
	}

}
