package com.dalvik.application.server.deployer.impl;

import java.util.HashMap;
import java.util.Map;

import com.dalvik.application.server.deployer.exception.ServerDeployException;
import com.dalvik.application.server.deployer.resource.ApplicationContext;
import com.dalvik.application.server.deployer.resource.ServiceContext;
import com.dalvik.utils.ConfigFileReader;

public class MainDriver {

	private static final String configFilePath = "config.properties";
	private static final String servicePath = "service.war.path";
	private static final String serviceAddress = "service.host.address";
	private static final String serviceName = "service.host.name";
	private static final String servicePort = "service.host.port";
	private static final String utilPath = "util.war.path";
	private static final String utilAddress = "util.host.address";
	private static final String utilName = "util.host.name";
	private static final String utilPort = "util.host.port";
	private static Map<String, String> serverProps = null;

	public static void main(String args[]) {

		loadConfigurations();
		IServerDeployer serverDeployer = ServerDeployer.getInstance();
		ApplicationContext context = getApplicationContext(serverProps);

		try {
			serverDeployer.onInit(context);
			serverDeployer.onStart(context);
		} catch (ServerDeployException e) {
			e.printStackTrace();
		}
	}

	private static ApplicationContext getApplicationContext(Map<String, String> props) {

		Map<String, ServiceContext> serviceMap = new HashMap<>();

		for (Map.Entry<String, String> entry : props.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (key.contains("service")) {
				String service = "service." + key.split("\\.")[0];
				if (!serviceMap.containsKey(service)) {
					ServiceContext context = new ServiceContext();
					serviceMap.put(service, context);
				}

				if (key.contains(servicePath)) {
					serviceMap.get(service).setServicePath(value);
				} else if (key.contains(serviceName)) {
					serviceMap.get(service).getHost().setHostName(value);
				} else if (key.contains(servicePort)) {
					serviceMap.get(service).getHost().setHostPort(value);
				} else if (key.contains(serviceAddress)) {
					serviceMap.get(service).getHost().setHostAddress(value);
				}

			} else if (key.contains("util")) {
				String service = "util." + key.split("\\.")[0];
				if (!serviceMap.containsKey(service)) {
					ServiceContext context = new ServiceContext();
					serviceMap.put(service, context);
				}

				if (key.contains(utilPath)) {
					serviceMap.get(service).setServicePath(value);
				} else if (key.contains(utilName)) {
					serviceMap.get(service).getHost().setHostName(value);
				} else if (key.contains(utilPort)) {
					serviceMap.get(service).getHost().setHostPort(value);
				} else if (key.contains(utilAddress)) {
					serviceMap.get(service).getHost().setHostAddress(value);
				}
			}
		}

		ApplicationContext appContext = new ApplicationContext();
		for (Map.Entry<String, ServiceContext> entry : serviceMap.entrySet()) {
			if (entry.getKey().contains("util")) {
				appContext.getUtilService().add(entry.getValue());
			} else if (entry.getKey().contains("service")) {
				appContext.getAvailableService().add(entry.getValue());
			}
		}
		return appContext;
	}

	private static void loadConfigurations() {
		serverProps = ConfigFileReader.getProperties(configFilePath);
	}

}
