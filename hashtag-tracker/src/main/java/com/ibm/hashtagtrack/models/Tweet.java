package com.ibm.hashtagtrack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweet {

    public Tweet() { }

    public Tweet(String text, Geo geo) {
        this.text = text;
        this.geo = geo;
    }

    private int sentimentType;

    private String newText;

    @JsonProperty("text")
    private String text;

    @JsonProperty("geo")
    private Geo geo;

}
