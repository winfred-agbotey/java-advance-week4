FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/service-1.0-SNAPSHOT.jar service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "service.jar"]
