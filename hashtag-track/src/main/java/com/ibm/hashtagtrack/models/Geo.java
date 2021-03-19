package com.ibm.hashtagtrack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geo {

    @JsonProperty("place_id")
    private String placeId;

    @JsonProperty("coordinates")
    private Coordinates coordinates;


}
