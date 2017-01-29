package com.dalvik.service.gateway.listeners;

import com.dalvik.service.gateway.resources.IServiceContext;

/*
 * Class which wants to get notify when new service is registered
 * into the registry
 */
public interface ServiceRegisteredListener extends IListener{

	public void onRegister(IServiceContext context);

}
