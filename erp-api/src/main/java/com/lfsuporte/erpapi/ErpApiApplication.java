package com.lfsuporte.erpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErpApiApplication {

	public static void main(String[] args) {
		// A marreta: Forçando a conexão direto na memória antes do Spring subir!
		System.setProperty("spring.data.mongodb.uri",
				"mongodb+srv://admin:thr45h4tt4ck@cluster0.tkbfvyg.mongodb.net/lfsuporte?retryWrites=true&w=majority");

		SpringApplication.run(ErpApiApplication.class, args);
	}
}