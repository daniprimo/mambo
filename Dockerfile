
FROM openjdk:17-jdk-slim
COPY /target/mambo-v1-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]