package com.dalvik.service.gateway.registry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.dalvik.service.gateway.exception.ServiceRegistrationException;
import com.dalvik.service.gateway.listeners.ServiceRegisteredListener;
import com.dalvik.service.gateway.listeners.ServiceUnRegisteredListener;
import com.dalvik.service.gateway.loadbalancer.LoadBalancer;
import com.dalvik.service.gateway.resources.IServiceContext;
import com.dalvik.service.gateway.resources.ServiceContext;

public class ServiceRegistryManager implements IServiceRegistryManager {

	private static ServiceRegistryManager instance;

	private Map<IServiceContext, Boolean> serviceLookUp;
	private Set<ServiceRegisteredListener> serviceRegisterListenerSet;
	private Set<ServiceUnRegisteredListener> serviceUnRegisterListenerSet;

	public static ServiceRegistryManager getInstance() {
		if (instance == null) {
			synchronized (ServiceRegistryManager.class) {
				instance = new ServiceRegistryManager();
			}
		}
		return instance;
	}

	private ServiceRegistryManager() {
		serviceLookUp = new HashMap<>();
		serviceRegisterListenerSet = new HashSet<>();
		serviceUnRegisterListenerSet = new HashSet<>();
		registerAllListeners();
	}

	private void registerAllListeners() {
		serviceRegisterListenerSet.add(LoadBalancer.getInstance());
	}

	@Override
	public void registerService(ServiceContext context) throws ServiceRegistrationException {
		synchronized (serviceLookUp) {
			if (!serviceLookUp.containsKey(context)) {
				serviceLookUp.put(context, true);
				onServiceRegisterNotifyListener();
			} else {
				throw new ServiceRegistrationException("Service already registerd.");
			}
		}
	}

	private void onServiceRegisterNotifyListener() {
		Iterator<ServiceRegisteredListener> iterator = serviceRegisterListenerSet.iterator();
		while (iterator.hasNext()) {
			ServiceRegisteredListener listener = iterator.next();
			for (Entry<IServiceContext, Boolean> entry : serviceLookUp.entrySet()) {
				IServiceContext context = entry.getKey();
				listener.onRegister(context);
			}
		}
	}

	@Override
	public void unRegisterService(ServiceContext context) throws ServiceRegistrationException {
		synchronized (serviceLookUp) {
			if (serviceLookUp.containsKey(context)) {
				serviceLookUp.remove(context);
				onServiceUnRegisterNotifyListener();
			} else {
				throw new ServiceRegistrationException("Service does not exist in LookUp.");
			}
		}
	}

	private void onServiceUnRegisterNotifyListener() {
		Iterator<ServiceUnRegisteredListener> iterator = serviceUnRegisterListenerSet.iterator();
		while (iterator.hasNext()) {
			ServiceUnRegisteredListener listener = iterator.next();
			for (Entry<IServiceContext, Boolean> entry : serviceLookUp.entrySet()) {
				IServiceContext context = entry.getKey();
				listener.onUnregister(context);
			}
		}
	}

	@Override
	public void disableService(ServiceContext context) throws ServiceRegistrationException {
		synchronized (serviceLookUp) {
			if (serviceLookUp.containsKey(context)) {
				serviceLookUp.put(context, false);
			} else {
				throw new ServiceRegistrationException("Service does not Exist in Lookup");
			}
		}
	}

	@Override
	public void enableService(ServiceContext context) throws ServiceRegistrationException {
		synchronized (serviceLookUp) {
			if (serviceLookUp.containsKey(context)) {
				serviceLookUp.put(context, true);
			} else {
				throw new ServiceRegistrationException("Service does not Exist in Lookup");
			}
		}
	}

	/**
	 * return new Map always
	 * 
	 * @return
	 */
	public Map<IServiceContext, Boolean> getAllAvailableServices() {
		return null;
	}

}
