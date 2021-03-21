package com.ibm.hashtagtrack.network;


import com.ibm.hashtagtrack.models.Coordinates;
import com.ibm.hashtagtrack.models.Geo;
import com.ibm.hashtagtrack.models.Hashtag;
import com.ibm.hashtagtrack.models.Tweet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Network client Using Spring Cloud Open Feign
 *
 * @author Warley Vinicius
 */
@Primary
@FeignClient(name = "twitterHashtagTracks", url = "${url.twitter.search}", fallback = TwitterHashtagsClient.TwitterHashtagsClientFallback.class)
public interface TwitterHashtagsClient {

    /**
     * Performing the hashtags search with the "query" being sent using Spring cloud openfeign.
     *
     * @param search     hashtag to be searched
     * @param maxResults Maximum amount of results (Obs: The maximum search limit is 100 results),
     *                   i'm using default 100.
     * @param field      field of geolocation attributes, the default is 'geo'
     * @param token      Twitter api token.
     * @return All results with the searched hashtag.
     */
    @GetMapping("recent")
    Hashtag twitterHashtagTrack(@RequestParam(value = "query") String search,
                                @RequestParam(value = "max_results") String maxResults,
                                @RequestParam(value = "tweet.fields") String field,
                                @RequestHeader(value = HttpHeaders.AUTHORIZATION) String token);


    /**
     * Fallback in case the Twitter api does not respond.
     */
    @Component
    class TwitterHashtagsClientFallback implements TwitterHashtagsClient {

        /**
         * In this fallback it returns 12 fixed locations on the map as a fallback
         *
         * @return Object hashtag with 12 tweets mocked data hardcoded.
         */
        @Override
        public Hashtag twitterHashtagTrack(String search, String maxResults, String field, String token) {

            String point = "Point";
            String fallback = "Fallback";
            List<Tweet> tweets = new ArrayList<>();
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-49.455564", "-16.888660")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-47.805653", "-21.186973")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-49.397665", "-20.838278")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-50.461686", "-21.230502")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-46.670929", "-23.594194")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-38.440959", "-12.924261")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-38.963305", "-12.254128")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-45.038280", "-12.125264")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-59.955166", "-3.118576" )))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-58.443252", "-3.178910" )))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-78.471094", "-0.263671" )))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-56.007474", "-32.694866")))));

            Hashtag hashtag = new Hashtag();
            hashtag.setTweets(tweets);

            return hashtag;
        }
    }

}
