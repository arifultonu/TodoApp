#FROM openjdk:11
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} todoapp.jar
#ENTRYPOINT ["java","-jar","/todoapp.jar"]

FROM openjdk:11
LABEL maintainer="www.smefinance.eu"
ADD ./target/todoapp-0.0.1-SNAPSHOT.jar todoapp.jar
ENTRYPOINT ["java", "-jar", "todoapp.jar"]


# For Java 8, try this
# FROM openjdk:8-jdk-alpine

## For Java 11, try this
#FROM adoptopenjdk/openjdk11:alpine-jre
#
## Refer to Maven build -> finalName
#ARG JAR_FILE=target/*.jar
#
## cd /opt/app
##WORKDIR /opt/app
#
## cp target/spring-boot-web.jar /opt/app/app.jar
#COPY ${JAR_FILE} todoapp.jar
#
## java -jar /opt/app/app.jar
#ENTRYPOINT ["java","-jar","todoapp.jar"]