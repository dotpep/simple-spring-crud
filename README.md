# Simple Spring CRUD

This is Simple Spring Boot CRUD with MongoDB, REST API for get, create, update and delete items.

## Swagger Endpoints Demo`

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

## MongoDB

GET:

```json
[
    {
        "id": "66f12617edd6c6ffa379a00d",
        "name": "Anime Figure: Goku",
        "description": "A detailed action figure of Goku from Dragon Ball Z, perfect for collectors.",
        "price": 29.99,
        "createdAt": "2024-09-23T13:09:28.691",
        "updatedAt": "2024-09-23T13:09:28.691"
    },
    {
        "id": "66f12617edd6c6ffa379a00f",
        "name": "Manga Set: One Piece Volumes 1-10",
        "description": "A complete set of the first ten volumes of One Piece manga.",
        "price": 79.99,
        "createdAt": "2024-09-23T13:11:02.456",
        "updatedAt": "2024-09-23T13:11:02.456"
    }
]
```

POST:

```json
[
    {
        "name": "Gaming Mouse: Razer DeathAdder",
        "description": "High-precision gaming mouse with customizable RGB lighting.",
        "price": 49.99
    }
]
```

PATCH (`http://localhost:8080/item{id}`) (also you can update other fields):

```json
[
    {
        "price": 69.99
    }
]
```

DELETE (`http://localhost:8080/item{id}`):

- will respond with `Item was deleted successfully!`
