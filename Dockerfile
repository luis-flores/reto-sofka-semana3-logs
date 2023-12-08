FROM openjdk:17
WORKDIR /app
COPY build/libs/logs-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8086
CMD ["java", "-jar", "app.jar"]
