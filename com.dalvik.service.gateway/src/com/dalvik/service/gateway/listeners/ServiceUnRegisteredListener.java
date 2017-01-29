package com.dalvik.service.gateway.listeners;

import com.dalvik.service.gateway.resources.IServiceContext;

/*
 * Class which wants to get notify when a service is unregistered
 * from the registry
 */
public interface ServiceUnRegisteredListener extends IListener {

	public void onUnregister(IServiceContext context);

}
