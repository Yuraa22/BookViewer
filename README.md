#Read me
This is a web application written in Kotlin with Spring Boot.
It was made as a practice for using different technologies.
Data persists in Postgresql database and this should be configured properly.

##Set connection properties
Under bookViewer\src\main\resources
- In application.properties change username, password and db name
- In docker-compose.yml change same parameters

##Build app
gradlew build (Windows)

##Starting up
docker-compose up

##Using app
username = bvUser
password = bvUser