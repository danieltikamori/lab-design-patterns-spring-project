package cc.tkmr.labdesignpatternsspringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * Lab Design Patterns using Spring Boot
 * The following modules are used in this project:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 * - OpenAPI (manually configured)
 *
 * @author Daniel Tikamori
 *
 */
@EnableFeignClients
@SpringBootApplication
public class LabDesignPatternsSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabDesignPatternsSpringProjectApplication.class, args);
	}

}
