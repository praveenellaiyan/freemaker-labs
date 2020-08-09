package com.practice.productmanagement;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.practice.productmanagement.model.Product;
import com.practice.productmanagement.repository.ProductRepository;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
public class ProductManagementApplication implements ApplicationRunner {
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Product p1 = new Product("Cap", 10, Instant.now(), null);
		productRepository.save(p1);
	}

}


