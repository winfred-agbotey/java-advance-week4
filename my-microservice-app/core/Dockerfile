# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/core-1.0-SNAPSHOT.jar core.jar

# Expose the application port (if applicable)
EXPOSE 8083

# Command to run the application
ENTRYPOINT ["java", "-jar", "core.jar"]
