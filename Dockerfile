
FROM openjdk:17-jdk-slim
COPY --from=build target/mambo-v1-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080