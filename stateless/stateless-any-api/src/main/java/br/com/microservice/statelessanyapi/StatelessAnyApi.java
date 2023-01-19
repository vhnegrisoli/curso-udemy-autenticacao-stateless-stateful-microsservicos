package br.com.microservice.statelessanyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StatelessAnyApi {

	public static void main(String[] args) {
		SpringApplication.run(StatelessAnyApi.class, args);
	}
}
