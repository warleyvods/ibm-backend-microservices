package com.ibm.hashtagtrack.service;


import com.ibm.hashtagtrack.config.twitter.TwitterConfig;
import com.ibm.hashtagtrack.contraints.HTTPConstraints;
import com.ibm.hashtagtrack.models.Hashtag;
import com.ibm.hashtagtrack.models.HashtagEntity;
import com.ibm.hashtagtrack.models.Positions;
import com.ibm.hashtagtrack.models.Tweet;
import com.ibm.hashtagtrack.network.TwitterHashtagsClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService {

    private final TwitterConfig twitterConfig;
    private final TwitterHashtagsClient twitterHashtagsClient;
    private final HashtagService hashtagService;

    public TwitterService(TwitterConfig twitterConfig, TwitterHashtagsClient twitterHashtagsClient,
                          HashtagService hashtagService) {
        this.twitterConfig = twitterConfig;
        this.twitterHashtagsClient = twitterHashtagsClient;
        this.hashtagService = hashtagService;
    }

    /**
     * Main method that converts all 100 tweets found to a list of positions using latitude and longitude.
     * The Method also uses Cache, so that there is no overhead of similar searches
     * in a short period of time that could result in excessive use of the api.
     *
     * Note: Cache time of 5 seconds for invalidity. After 5 seconds even if the search
     * is the same hashtag it searches directly on the Twitter api
     *
     * @param search Hashtag sent in search directly from the frontend
     * @return List of positions of Tweets that were found comment with
     * Positions of type Point ignoring Tweets that are not located.
     */
    @Cacheable("twitterCoordinates")
    public List<Positions> getTwitterCoordinates(String search) {
        Hashtag hashtag = twitterHashtagsClient.twitterHashtagTrack(search, twitterConfig.getMaxResults(),
                twitterConfig.getTweetFields(), HTTPConstraints.BEARER_AUTHORIZATION + twitterConfig.getBearerToken());

        hashtagService.saveHashtag(new HashtagEntity(search));
        return getPositions(hashtag);
    }

    private List<Positions> getPositions(Hashtag hashtag) {
        List<Positions> positionsList = new ArrayList<>();

        /*Ignoring tweets without 'Point' type coordinates*/
        for (Tweet tweet : hashtag.getTweets()) {
            if (tweet.getGeo() != null && tweet.getGeo().getCoordinates() != null) {
                positionsList.add(new Positions(tweet.getGeo().getCoordinates().getCoordinates().get(1),
                        tweet.getGeo().getCoordinates().getCoordinates().get(0), tweet.getText()));
            }
        }

        return positionsList;
    }

}
