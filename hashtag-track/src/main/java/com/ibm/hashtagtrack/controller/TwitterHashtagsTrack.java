package com.ibm.hashtagtrack.controller;

import com.ibm.hashtagtrack.service.TwitterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class TwitterHashtagsTrack {

    private final TwitterService twitterService;

    public TwitterHashtagsTrack(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping("/hashtags")
    public ResponseEntity<Object> getHashtagsCoordinates(@RequestParam String search) throws IOException, URISyntaxException {
        Object twitterCoordinates = twitterService.getTwitterCoordinates(search);
        return new ResponseEntity<>(twitterCoordinates, HttpStatus.OK);
    }

}
