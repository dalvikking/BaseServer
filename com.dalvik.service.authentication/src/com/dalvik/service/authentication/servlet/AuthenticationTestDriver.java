package com.dalvik.service.authentication.servlet;

import com.dalvik.tomcat.exception.WebAppDeployerException;
import com.dalvik.tomcat.impl.MicroServiceDeployer;

public class AuthenticationTestDriver {

	public static void main(String[] args) {
		try {
			MicroServiceDeployer.getInstance().deploy(8889, "/authentication", "build/libs/authentication.war");
			MicroServiceDeployer.getInstance().start();
		} catch (WebAppDeployerException e) {
			e.printStackTrace();
		}
	}

}
