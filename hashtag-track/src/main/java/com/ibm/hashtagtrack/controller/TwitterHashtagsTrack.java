package com.ibm.hashtagtrack.controller;

import com.ibm.hashtagtrack.models.Positions;
import com.ibm.hashtagtrack.service.TwitterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TwitterHashtagsTrack {

    private final TwitterService twitterService;

    public TwitterHashtagsTrack(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping("/hashtags")
    public ResponseEntity<List<Positions>> getHashtagsCoordinates(@RequestParam String search) {
        List<Positions> twitterCoordinates = twitterService.getTwitterCoordinates(search);
        return new ResponseEntity<>(twitterCoordinates, HttpStatus.OK);
    }

}
