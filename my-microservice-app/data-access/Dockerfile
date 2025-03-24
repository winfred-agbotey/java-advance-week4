FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/data-access-17.jar data-access.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "data-access.jar"]
