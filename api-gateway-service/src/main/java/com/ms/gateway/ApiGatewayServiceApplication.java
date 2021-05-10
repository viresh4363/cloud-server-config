package com.ms.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ApiGatewayServiceApplication {

	private  static final Logger LOGGER = LoggerFactory.getLogger(ApiGatewayServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Inside ApiGatewayServiceApplication =>");
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

}
