FROM eclipse-temurin:17-jdk-alpine
VOLUME /app
COPY target/mambo-v1-0.0.1-SNAPSHOT.jar /app/spring-app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
