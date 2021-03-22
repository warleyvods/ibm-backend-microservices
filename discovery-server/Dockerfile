FROM openjdk:11-jre-slim

EXPOSE 8081

WORKDIR /app

COPY target/discovery-server.jar /app/discovery-server.jar

ENTRYPOINT ["java", "-jar", "discovery-server.jar"]
