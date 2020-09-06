#Read me
This is a web application written in Kotlin with Spring Boot.
It was made as a practice for using different technologies.
Data persists in PostgreSQL database and this should be configured properly.

##Update
Started as a web application, included JWT authentication so it became a web API

#Prerequisites
- Installed Java
- Installed Docker and started service
- Installed PostgreSQL and started service

##Set connection properties
Under bookViewer\src\main\resources
- In application.properties change username, password and db name
- In docker-compose.yml change same parameters

##Build app
- gradlew build (Windows)

##Starting up
- docker-compose up

##Stopping up
- docker-compose down

##Using app
use localhost:8080/login
username: bvUser
password: bvUser
or
username: bvUser2
password: bvUser2

After successful login, JWT token is returned on the page. Copy it and send it in header
- Authorization: JWT_value

##Available API
- view books by user - localhost:8080/
- read book by isbn - localhost:8080/readbooks/{isbn}
- add book - localhost:8080/addbook
