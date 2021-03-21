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
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-16.888660", "-49.455564")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-21.186973", "-47.805653")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-20.838278", "-49.397665")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-21.230502", "-50.461686")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-23.594194", "-46.670929")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-12.924261", "-38.440959")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-12.254128", "-38.963305")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-12.125264", "-45.038280")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-3.118576", "-59.955166")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-3.178910", "-58.443252")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-0.263671", "-78.471094")))));
            tweets.add(new Tweet(fallback, new Geo(new Coordinates(point, Arrays.asList("-32.694866", "-56.007474")))));

            Hashtag hashtag = new Hashtag();
            hashtag.setTweets(tweets);

            return hashtag;
        }
    }

}
