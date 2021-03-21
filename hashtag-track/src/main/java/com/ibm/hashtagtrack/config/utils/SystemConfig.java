package com.ibm.hashtagtrack.config.utils;

import feign.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Config application class
 * @author Warley Vinicius
 */
@Configuration
public class SystemConfig {

    /**
     * Logger for the Spring cloud open feign
     * Status logger: NONE, BASIC, HEADERS, FULL
     * @return logger;
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * Bean of RestTemplate
     * @return restTemplate build.
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
