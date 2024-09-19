FROM eclipse-temurin:21-alpine
LABEL authors="eduardo"

VOLUME /temp
EXPOSE 80
ARG JAR_FILE=target/api-credmail-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
RUN ls -l /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]