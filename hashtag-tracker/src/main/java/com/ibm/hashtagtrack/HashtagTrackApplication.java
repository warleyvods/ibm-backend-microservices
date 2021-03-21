package com.ibm.hashtagtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class HashtagTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(HashtagTrackApplication.class, args);
    }

}
