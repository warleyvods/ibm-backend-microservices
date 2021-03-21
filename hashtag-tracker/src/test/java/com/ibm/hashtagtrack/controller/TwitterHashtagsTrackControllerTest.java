package com.ibm.hashtagtrack.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = {
        "url.twitter.search=https://api.twitter.com/2/tweets/search/",
        "url.twitter.maxResults=100",
        "url.twitter.tweetField=geo",
        "url.twitter.url.twitter.bearerToken=AAAAAAAAAAAAAAAAAAAAANsXNwEAAAAApWjPfT%2F1mVFhO5TK8LUsoOaacKo%3DdKhDWFzOo99tv7lQuhDLAd0ZrzfLzcInIZH9WvTltZPMW4HUFt"
})
@AutoConfigureMockMvc
public class TwitterHashtagsTrackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String QUERY = "#goiania";

    @Test
    public void getHashtagsCoordinates() throws Exception {
        mockMvc.perform(get("/v1/hashtag").param("search", QUERY))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void dontGetHashtagsCoordinatesWithoutQuery() throws Exception {
        mockMvc.perform(get("/v1/hashtag"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testFallbacHystrixWhenValueIsInvalid() throws Exception {
        mockMvc.perform(get("/v1/hashtag").param("search", " "))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void testFallbacHystrixWhenValueIsInvalidWithNull() throws Exception {
        mockMvc.perform(get("/v1/hashtag").param("search", ""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

}
