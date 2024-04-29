package com.example.apicar;

import com.example.apicar.models.Carro;
import com.example.apicar.models.Marca;
import com.example.apicar.repositories.CarroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApiCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCarApplication.class, args);
	}

}
