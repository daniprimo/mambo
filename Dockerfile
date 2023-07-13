
FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar  app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
