package com.ibm.hashtagtrack.config.twitter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class TwitterConfig {


    @Value("${url.twitter.search}")
    private String url;

    private String maxResults = "100";

    private String tweetFields = "geo";

    private String bearerToken = "AAAAAAAAAAAAAAAAAAAAANsXNwEAAAAApWjPfT%2F1mVFhO5TK8LUsoOaacKo%3DdKhDWFzOo99tv7lQuhDLAd0ZrzfLzcInIZH9WvTltZPMW4HUFt";

}
