package com.authenticate.authenticate;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public ConfigurableServletWebServerFactory servletContainer() {
//		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//
//		// First connector - port 8080
//		factory.addAdditionalTomcatConnectors(createConnector(8080));
//
//		// Second connector - port 9090
//		factory.addAdditionalTomcatConnectors(createConnector(3000));
//
//		return factory;
//	}
//
//	// Method to create a Tomcat connector with a specific port
//	private Connector createConnector(int port) {
//		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//		connector.setPort(port);
//		return connector;
//	}

}
