package com.ibm.hashtagtrack.controller;

import com.ibm.hashtagtrack.models.HashtagEntity;
import com.ibm.hashtagtrack.models.TweetDTO;
import com.ibm.hashtagtrack.service.HashtagService;
import com.ibm.hashtagtrack.service.TwitterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoints controller API
 * @author Warley Vinicius
 */
@RestController
public class TwitterHashtagsTrackController {

    private final TwitterService twitterService;
    private final HashtagService hashtagService;

    public TwitterHashtagsTrackController(TwitterService twitterService, HashtagService hashtagService) {
        this.twitterService = twitterService;
        this.hashtagService = hashtagService;
    }

    /**
     * This method is responsible for searching for a list of hashtags referring in a search
     * and save the hashtag for future search.
     *
     * @param search string hashtag for the search
     * @return list of positions found referenced in latitude and longitude
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
    })
    @Operation(
            summary = "List of positions found referenced in latitude and longitude",
            description = "Searches for the hashtag if it has been posted with active location",
            tags = "Hashtag Tracker Search Controller"
    )
    @GetMapping("/v1/hashtag")
    public ResponseEntity<List<TweetDTO>> getHashtagsCoordinates(@RequestParam String search) {
        List<TweetDTO> twitterCoordinates = twitterService.getTwitterCoordinates(search);
        return new ResponseEntity<>(twitterCoordinates, HttpStatus.OK);
    }

    /**
     * This method is responsible for listing all the searched hashtags saved in the database
     *
     * @return list of recently searched hashtags
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
    })
    @Operation(
            summary = "Listing all the searched hashtags saved in the database",
            description = "All hashtags recent search",
            tags = "Hashtag Tracker Search Controller"
    )
    @GetMapping("/v1/findAllHashtags")
    public ResponseEntity<List<HashtagEntity>> findAllHashtags() {
        List<HashtagEntity> allHashtag = hashtagService.findAllHashtag();
        return new ResponseEntity<>(allHashtag, HttpStatus.OK);
    }

}
