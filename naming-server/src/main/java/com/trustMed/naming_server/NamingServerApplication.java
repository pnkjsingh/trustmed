package com.trustMed.naming_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingServerApplication {

	public static void main(String[] args) throws InterruptedException {		
		Thread.sleep(20000);
		SpringApplication.run(NamingServerApplication.class, args);
	}

}
