package com.client;

import brave.sampler.Sampler;
import com.client.controler.ClientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.client")
@EnableDiscoveryClient
public class MicroserviceClientApplication {

    @Autowired
	ClientController clientController;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientApplication.class, args);
	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;}
}
