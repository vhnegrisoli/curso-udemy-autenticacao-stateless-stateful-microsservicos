package br.com.microservice.statefulanyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StatefulAnyApi {

	public static void main(String[] args) {
		SpringApplication.run(StatefulAnyApi.class, args);
	}
}
