package com.ibm.hashtagtrack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweet {

    @JsonProperty("geo")
    private Geo geo;

}
