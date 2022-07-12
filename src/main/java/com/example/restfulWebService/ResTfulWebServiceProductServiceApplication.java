package com.example.restfulWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@SpringBootApplication
@OpenAPIDefinition(info= @Info(title = "Product Rest Api",description = " This is rest api services"))
public class ResTfulWebServiceProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulWebServiceProductServiceApplication.class, args);
	}
	@Bean
	void printer() {
		System.err.println("Please visite swigger-UI \nhttp://localhost:8080/swagger-ui.html");
	}

}
