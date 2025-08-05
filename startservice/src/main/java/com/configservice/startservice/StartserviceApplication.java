package com.configservice.startservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class StartserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartserviceApplication.class, args);
	}

}
