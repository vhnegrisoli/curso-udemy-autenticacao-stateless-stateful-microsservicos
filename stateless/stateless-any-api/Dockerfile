FROM openjdk:17-alpine
COPY build/libs/stateless-any-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]