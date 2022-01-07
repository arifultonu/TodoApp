FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/todoapp-0.0.1-SNAPSHOT.jar todoapp.jar
ENTRYPOINT ["java","-jar","todoapp.jar"]