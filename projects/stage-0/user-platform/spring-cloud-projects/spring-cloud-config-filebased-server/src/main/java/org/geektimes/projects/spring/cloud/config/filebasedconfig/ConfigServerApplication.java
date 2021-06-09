package org.geektimes.projects.spring.cloud.config.filebasedconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication {
	@Value("${my.name}")
	private String myName;

	@Value("${my.age}")
	private int myAge;

	@Bean
	public ApplicationRunner runner() {
		return args -> System.out.printf("my.name = %s, my.age = %d %n", myName, myAge);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class);
	}

}
