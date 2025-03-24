FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar data-access.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "data-access.jar"]
