package com.dalvik.application.server.deployer.resource;

import com.dalvik.application.server.deployer.exception.ServiceDeployException;

abstract class AbstractService implements IService {

	@Override
	public void onInit(IServiceContext context) throws ServiceDeployException {
		// TODO Auto-generated method stub
		// init DB Connection
		// load data in memory
	}

	@Override
	public void onStart(IServiceContext context) throws ServiceDeployException {
		// TODO Auto-generated method stub
		// Deploy Application war here using embedded Tomcat

	}

	@Override
	public void onStop(IServiceContext context) throws ServiceDeployException {
		// TODO Auto-generated method stub
		// Stop Tomcat here
	}

}
