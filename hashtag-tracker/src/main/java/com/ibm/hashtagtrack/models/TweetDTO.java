package com.ibm.hashtagtrack.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TweetDTO {

    public TweetDTO() {
    }

    public TweetDTO(String latitude, String longitude, String label) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.label = label;
    }

    private String latitude;
    private String longitude;
    private String label;
    private String sentimental;

}
