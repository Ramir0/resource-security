FROM openjdk:17.0.1-jdk-slim-buster

WORKDIR /app
COPY target/resource-security-1.0.0.jar security-service.jar
EXPOSE 8088

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "security-service.jar"]
