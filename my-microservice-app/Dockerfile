FROM maven:3.8.4-openjdk-17-slim AS maven-build
LABEL authors="winifred"

WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM  openjdk:17-jdk-slim AS maven-runtime
WORKDIR /app
COPY --from=maven-build /app/api/target/*.jar /app/app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]