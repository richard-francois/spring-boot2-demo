# Spring Boot 2.4.2 - DEMO Project

### This project to show use of Spring Boot 2.x new features.

Frameworks used :
- Spring Boot
- Spring Framework
- Spring Data JPA
- Spring Security 
- ThymeLeaf + BootStrap (UI)
  
Build and dependancies management :
- Maven
  
Developpement langage :
- Java 11

Project initialized from https://start.spring.io
with following dependencies:
- Spring Boot DevTools (click `Build Project` to deploy static resources with IntelliJ)
- Spring Web
- Thymeleaf
- Spring security
- Spring Data JPA
- Spring Boot Actuator
- MySQL Driver

JPA features + ThymeLead features created by following : https://www.youtube.com/watch?v=bcV0WtOoY54&list=PLGRDMO4rOGcM7B0TsM_-2efML7LAOriWV&index=2


# Pre-requisites
## MySQL
- MySQL 8.0+ , in docker container
- User root:root
- initialisation instructions on a fresh empty Database  
    - `create schema demo;`
    - `create user 'root'@'172.17.0.1' identified by 'root';`
    - `grant all privileges on demo.* TO 'root'@'172.17.0.1';`
    - `flush privileges;`

**--> see resources/data.csv**

# Build and run
- `mvn clean install`

- `mvn spring-boot:run` **(!) dot not run from IntelliJ (!)**

# Connecting to application

- http://localhost:8080
    - Login : user 
    - Password : { displayed in console log }
