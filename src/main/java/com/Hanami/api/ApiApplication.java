package com.Hanami.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Blog Hanami", version = "0.5.0", description = "A API oferece endpoints para criar, atualizar, recuperar e deletar publicações e comentários de publicações", contact = @Contact(name = "Desenvolvido por: SQUAD10 ")))
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
