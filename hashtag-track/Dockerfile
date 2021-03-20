FROM openjdk

WORKDIR /app

ENV SPRING_CLOUD_CONFIG="http://config-server:8083"
ENV EUREKA_ENV_NET="http://discovery:8081"

COPY target/hashtag-track.jar /app/hashtag-track.jar

ENTRYPOINT ["java", "-jar", "hashtag-track.jar"]
