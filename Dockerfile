FROM eclipse-temurin:17-jdk-alpine
VOLUME /app
COPY target/*.jar /app/spring-app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
