FROM openjdk:14-jdk-alpine
MAINTAINER Yuraa
VOLUME /tmp
EXPOSE 8080
ADD build/libs/bookViewer-0.0.1-SNAPSHOT.jar bookViewer.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bookViewer.jar"]