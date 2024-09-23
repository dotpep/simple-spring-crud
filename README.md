# Simple Spring CRUD

This is Simple Spring CRUD with MongoDB, REST API for get products as item, search, and create item.

## Swagger Endpoints Demo

![REST API Endpoints/Routes](swagger_spring_crud_endpoints.png)

## Running

- Download openJDK java 17.0, and MongoDB 8.0
- git clone `git clone https://github.com/dotpep/simple-spring-crud.git`
- clean and install dependency `.\mvnw clean install`
- run mvnw `.\mvnw spring-boot:run`

- goto: swagger openapi `http://localhost:8080/swagger-ui/index.html#/`


## Techs

- Spring Boot, openJDK17
- MongoDB, Community 8.0
- CRUD REST API
- Swagger (OpenAPI) on `http://localhost:8080/swagger-ui/index.html`
- Maven

dependencies:

- Spring Web
- Spring Data MongoDB
- springdoc-openapi-starter-webmvc-ui 2.2.0

## Item Model

- id
- name
- description
- price
- created_at
