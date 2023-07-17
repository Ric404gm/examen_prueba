package com.ricardocamacho.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ricardocamacho")
@EnableJpaRepositories(basePackages ={"com.ricardocamacho.examen.persistence.repository"})
@EntityScan(basePackages ={"com.ricardocamacho.examen.persistence.entity"})
public class ExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

}
