package com.project.recipeprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.project.recipeprovider*")
@EntityScan("com.project.recipeprovider.entity")
@EnableJpaRepositories("com.project.recipeprovider.repository")
public class RecipeProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeProviderApplication.class, args);
	}

}
