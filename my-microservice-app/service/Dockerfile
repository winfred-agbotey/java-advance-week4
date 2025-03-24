FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*jar service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "service.jar"]
