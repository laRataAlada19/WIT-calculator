FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/producer-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
