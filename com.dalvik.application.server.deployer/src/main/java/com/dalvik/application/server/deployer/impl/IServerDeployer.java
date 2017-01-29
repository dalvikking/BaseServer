package com.dalvik.application.server.deployer.impl;

import com.dalvik.application.server.deployer.exception.ServerDeployException;
import com.dalvik.application.server.deployer.resource.ApplicationContext;

public interface IServerDeployer {

	public void onInit(ApplicationContext context) throws ServerDeployException;

	public void onStart(ApplicationContext context) throws ServerDeployException;

	public void onStop(ApplicationContext context) throws ServerDeployException;
}
