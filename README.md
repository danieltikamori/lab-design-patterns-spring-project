# Lab Design Patterns in Java with Spring Boot

## This lab will help you:

- Understand the design patterns in Java
- Learn how to use Spring Boot
- Learn how to use OpenApi and Swagger
- Learn how to use OpenFeign
- Learn how to use Spring Web
- Learn how to use Spring Data JPA
- Learn how to use H2 database

## Getting Started
- [Reference Documentation](https://maven.apache.org/guides/index.html)
- [Guides](https://spring.io/guides/gs/)
- [Additional Links](https://spring.io/guides)
- [Declarative REST calls with Spring Cloud OpenFeign sample](https://github.com/spring-cloud-samples/feign-eureka)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
- [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
- [Spring Cloud Gateway](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/)
- [Spring Cloud Sleuth](https://docs.spring.io/spring-cloud-sleuth/docs/current/reference/html/)

## Versions and implementations

Design patterns used in this project:
- Singleton
- Strategy/Repository
- Facade

### Dependencies (updated versions may break the current code)
- Java 11
- Spring Boot 2.5.4
- Spring Boot Maven Plugin 4.0.0
- OpenFeign 4.1.0
- Spring Cloud version 2020.0.3

## Testing

Open localhost:8080/swagger-ui.html to view the swagger UI

Try POST to insert new client. Only id and cep are required.

Try GET /clients to get all clients.

Try GET /clients/{id} to get a specific client.

Try PUT /clients/{id} to update a specific client.

Try DELETE /clients/{id} to delete a specific client.

## Disclaimer
This project is for learning purposes only.