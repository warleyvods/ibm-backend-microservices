package com.ibm.hashtagtrack.controller;

import com.ibm.hashtagtrack.models.HashtagEntity;
import com.ibm.hashtagtrack.models.Positions;
import com.ibm.hashtagtrack.service.HashtagService;
import com.ibm.hashtagtrack.service.TwitterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TwitterHashtagsTrackController {

    private final TwitterService twitterService;
    private final HashtagService hashtagService;

    public TwitterHashtagsTrackController(TwitterService twitterService, HashtagService hashtagService) {
        this.twitterService = twitterService;
        this.hashtagService = hashtagService;
    }

    @GetMapping("/v1/hashtag")
    public ResponseEntity<List<Positions>> getHashtagsCoordinates(@RequestParam String search) {
        List<Positions> twitterCoordinates = twitterService.getTwitterCoordinates(search);
        return new ResponseEntity<>(twitterCoordinates, HttpStatus.OK);
    }

    @GetMapping("/v1/findAllHashtags")
    public ResponseEntity<List<HashtagEntity>> findAllHashtags() {
        List<HashtagEntity> allHashtag = hashtagService.findAllHashtag();
        return new ResponseEntity<>(allHashtag, HttpStatus.OK);
    }

}
