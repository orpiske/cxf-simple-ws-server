/** 
   Copyright 2012 Otavio Rodolfo Piske

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package net.orpiske.cxf.example.webservice;

import java.net.URL;

import javax.xml.namespace.QName;

import net.orpiske.examples.cxf.webservice.TimeService;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;


public class ServerMain {
	
	public static URL getWSDL() {
		return ServerMain.class.getResource("/wsdl/timeservice/TimeService.wsdl");
	}
	
	public static void setupService() {
		
		
		
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();

		/*
		 * This is the service "interface" class. It is a Java interface which
		 * you use to implement the service
		 */
		factory.setServiceClass(TimeService.class);
		
		/*
		 * This is the service implementation. You create this class and it must
		 * implement the "serviceClass" (which is an interface) we just set
		 * above
		 */
		TimeServiceImpl service = new TimeServiceImpl();
		factory.setServiceBean(service);
		
		/*
		 * The server address
		 */
		factory.setAddress("http://localhost:8080/TimeService");
		
	
		/*
		 * Sets the WSDL URL location
		 */
		//factory.setWsdlURL("file:" + getWSDL().getPath());
		factory.setWsdlURL("classpath:/wsdl/timeservice/TimeService.wsdl");
		factory.setServiceName(new QName("http://www.orpiske.net/examples/cxf/webservice",
				"TimeService"));
		
		/*
		 * Logging goods ...
		 */
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		
		
		
		/*
		 * Create the service
		 */
		factory.create();	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Using alternate mode");

		setupService();

	}

}
