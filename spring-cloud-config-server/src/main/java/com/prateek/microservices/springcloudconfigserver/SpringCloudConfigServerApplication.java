package com.prateek.microservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/* @EnableConfigServer
 * To enable cloud config server
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
}
