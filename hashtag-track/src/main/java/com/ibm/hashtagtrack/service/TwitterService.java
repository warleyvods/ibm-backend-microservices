package com.ibm.hashtagtrack.service;


import com.ibm.hashtagtrack.config.twitter.TwitterConfig;
import com.ibm.hashtagtrack.contraints.HTTPConstants;
import com.ibm.hashtagtrack.models.Hashtag;
import com.ibm.hashtagtrack.twitter.TwitterHashtagsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitterService {

    private final TwitterConfig twitterConfig;
    private final TwitterHashtagsClient twitterHashtagsClient;

    @Autowired
    private RestTemplate restTemplate;

    public TwitterService(TwitterConfig twitterConfig, TwitterHashtagsClient twitterHashtagsClient) {
        this.twitterConfig = twitterConfig;
        this.twitterHashtagsClient = twitterHashtagsClient;
    }

    public Hashtag getTwitterCoordinates(String search) {
        Hashtag hashtag = twitterHashtagsClient.twitterHashtagTrack(search, twitterConfig.getMaxResults(),
                twitterConfig.getTweetFields(), HTTPConstants.BEARER_AUTHORIZATION + twitterConfig.getBearerToken());

        return hashtag;
    }




}
