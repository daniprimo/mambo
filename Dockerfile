FROM openJDK

WORKDIR /app

COPY target/mambo-v1-0.0.1-SNAPSHOT.jar /app/spring-app.jar

ENTRYPOINT [ "java", "-java", "spring-app.jar" ]
