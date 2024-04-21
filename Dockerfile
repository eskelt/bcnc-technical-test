# Use the official Maven image as a base image
FROM maven:3.8.4-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the entire project
COPY / /app

# Build the application
RUN mvn clean install -U

# Use the official OpenJDK image as a base image for the final image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the builder stage to the final image
COPY --from=builder /app/target/*.jar app.jar

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]