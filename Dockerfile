# Use a base Java image with Maven and JDK
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the JAR (adjust if your main class or target name is different)
RUN mvn clean package

# Use a lighter JDK runtime
FROM eclipse-temurin:17-jdk-jammy

# Set working directory in runtime image
WORKDIR /app

# Copy the built JAR from previous stage
COPY --from=build /app/target/*shaded.jar app.jar

# Run the app
CMD ["java", "-jar", "app.jar"]