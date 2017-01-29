package com.dalvik.service.gateway;

import com.dalvik.tomcat.exception.WebAppDeployerException;
import com.dalvik.tomcat.impl.MicroServiceDeployer;

public class GatewayTestDriver {

	public static void main(String[] args) {
		try {
			MicroServiceDeployer.getInstance().deploy(9999, "/gateway", "build/libs/gateway.war");
			MicroServiceDeployer.getInstance().start();
		} catch (WebAppDeployerException e) {
			e.printStackTrace();
		}

	}

}
