# Use Maven image with Java 17
FROM maven:3.8-openjdk-17

# Set the working directory
WORKDIR /app

# Copy source code and pom
COPY pom.xml .
COPY src /app/src

# Expose port
EXPOSE 8071

# Run using spring-boot plugin
CMD ["mvn", "spring-boot:run"]
