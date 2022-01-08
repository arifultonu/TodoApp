# TodoApp
 EastNetic SME Finance ToDo Web Application using Spring Boot and Angular

###Worked Docker Spring Boot todoapp and mysqldb##########
--Tuts Source: https://www.javainuse.com/devOps/docker/docker-mysql

--application.properties:
spring.jpa.database=mysql
spring.datasource.url=jdbc:mysql://mysqldb/smefinancetodoapp
spring.datasource.username=root
spring.datasource.password=root

--Dockerfile:
FROM openjdk:11
LABEL maintainer="www.smefinance.eu"
ADD ./target/todoapp-0.0.1-SNAPSHOT.jar todoapp.jar
ENTRYPOINT ["java", "-jar", "todoapp.jar"]

--intellij terninal
docker image build -t todoapp .

--CMD 
- docker ps
- docker network ls
- docker network create spring-net
- docker container run --name mysqldb --network spring-net -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=smefinancetodoapp -d mysql
- docker container inspect mysqldb
- docker container run --network spring-net --name todoapp-container -p 8080:8080 -d todoapp
- docker logs todoapp

-- Finally Open Browser - http://localhost:8080/
-- Test Using Restlet or postman to call API

#########End###############

### Docker Image for MySql:
-Open CMD as Administrator.
- docker images
- docker run -p 3307:3306 --name mysqldb mysql
- docker ps
- docker ps -a
- docker rm mysqldb
- docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=smefinancetodoapp mysql
- docker rm -f mysqldb
- docker run -d -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=smefinancetodoapp mysql
- docker logs mysqldb
- docker ps

####Docker Image for Spring Boot and Mysql with same network:
- docker ps
- docker images
- docker run -p 9090:8080 --name app -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 app
- docker networks ls

- docker network
- docker network create spring-net
- docker ps
- docker network connect spring-net mysqldb
- docker container inspect mysqldb
- docker ps -a

##Spring Boot - Dockerfile:
- FROM openjdk:11
  ARG JAR_FILE=target/*.jar
  COPY ${JAR_FILE} app.jar
  ENTRYPOINT ["java","-jar","/app.jar"]
  
# Intellij Idea- Terminal:
- docker build -t app .


- docker rm -f app
- docker run -p 9090:8080 --name app --net spring-net -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 app

- docker restart app
- docker logs app

- docker rm -f mysqldb
- docker run -d -p 3307:3306 --net spring-net --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=smefinancetodoapp "C:/Users/tonu2/Desktop/db":var/lib/mysql mysql
- docker logs mysqldb

- docker restart app
- docker logs app

##################################

###Another Process###
## CMD Command: 
-- docker-compose down
-- mvn clean install -DskipTests=true 
-- docker-compose up

------------Tag to docker hub---
-- docker tag springboot-docker-container arifultonu/todoapp:springboot-docker-container
-- docker push  arifultonu/todoapp:springboot-docker-container

###########################
Docker Compose to Docler Hub Tuts:
https://www.youtube.com/watch?v=DFuxCSI4ktY






























