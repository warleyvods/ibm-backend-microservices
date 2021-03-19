package com.ibm.hashtagtrack.twitter;



import com.ibm.hashtagtrack.models.Hashtag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Primary
@FeignClient(name = "twitterHashtagTracks", url = "${url.twitter.search}")
public interface TwitterHashtagsClient {

    @GetMapping("recent")
    Hashtag twitterHashtagTrack(@RequestParam(value = "query") String search,
                                @RequestParam(value = "max_results") String maxResults,
                                @RequestParam(value = "tweet.fields") String field,
                                @RequestHeader(value = HttpHeaders.AUTHORIZATION) String token);

}
