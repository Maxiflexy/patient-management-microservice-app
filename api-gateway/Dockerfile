FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy both pom.xml and source code at once
COPY . .

# Build directly without the separate dependency download step
RUN mvn clean package

FROM openjdk:21-jdk AS runner

WORKDIR /app

COPY --from=builder ./app/target/api-gateway-1.0.1.jar ./app.jar

EXPOSE 4000

ENTRYPOINT ["java", "-jar", "app.jar"]