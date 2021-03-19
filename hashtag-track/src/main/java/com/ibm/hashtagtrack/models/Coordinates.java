package com.ibm.hashtagtrack.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {

    @JsonProperty("type")
    private String type;

    @JsonProperty("coordinates")
    private List<String> coordinates;


}
