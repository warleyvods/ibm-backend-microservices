package com.ibm.hashtagtrack.config.twitter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Twitter config for the API
 * @author Warley Vinicius
 */
@Data
@Component
public class TwitterConfig {

    @Value("${url.twitter.search}")
    private String url;

    @Value("${url.twitter.maxResults}")
    private String maxResults;

    @Value("${url.twitter.tweetField}")
    private String tweetFields;

    @Value("${url.twitter.bearerToken}")
    private String bearerToken;

}
