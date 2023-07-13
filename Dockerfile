
FROM openjdk:latest
COPY --from=publish /target/*.jar  app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
