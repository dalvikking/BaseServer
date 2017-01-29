package com.dalvik.service.gateway.registry;

import com.dalvik.service.gateway.exception.ServiceRegistrationException;
import com.dalvik.service.gateway.resources.ServiceContext;

/*
 * It is used for registering/unregistering all available service in 
 * the microservice cluster. 
 */
public interface IServiceRegistryManager {

	public void registerService(ServiceContext context) throws ServiceRegistrationException;

	public void unRegisterService(ServiceContext context) throws ServiceRegistrationException;

	public void disableService(ServiceContext context) throws ServiceRegistrationException;

	public void enableService(ServiceContext context) throws ServiceRegistrationException;

}
