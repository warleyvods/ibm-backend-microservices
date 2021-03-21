FROM openjdk

WORKDIR /app

ENV SPRING_CLOUD_CONFIG="http://config-server:8083"
ENV EUREKA_ENV_NET="http://discovery:8081"
ENV DATABASE_CONNECTION_URL="jdbc:postgresql://db:5433/twitter"

COPY target/hashtag-tracker.jar /app/hashtag-tracker.jar

ENTRYPOINT ["java", "-jar", "hashtag-tracker.jar"]
