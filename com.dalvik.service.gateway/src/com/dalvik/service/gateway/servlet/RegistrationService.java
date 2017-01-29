package com.dalvik.service.gateway.servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dalvik.service.gateway.resources.Host;
import com.dalvik.service.gateway.resources.ServiceContext;

@Path("/service")
public class RegistrationService {

	@GET
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceContext registerService() {

		ServiceContext context = new ServiceContext();
		context.setServicePath("/service1");
		Host host = new Host();
		host.setHostPort("8888");
		host.setHostAddress("www.testservice.com");
		host.setHostName("/test");
		context.setHost(host);

		return context;
	}

	@GET
	@Path("/unregister")
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceContext unRegisterService() {

		ServiceContext context = new ServiceContext();
		context.setServicePath("/service1");
		Host host = new Host();
		host.setHostPort("8888");
		host.setHostAddress("www.testservice.com");
		host.setHostName("/test");
		context.setHost(host);
		return context;
	}

}
