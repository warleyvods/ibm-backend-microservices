package com.ibm.hashtagtrack.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TweetDTO {

    public TweetDTO() {
    }

    public TweetDTO(String latitude, String longitude, String label, String status) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.label = label;
        this.sentimental = status;
    }

    private String latitude;
    private String longitude;
    private String label;
    private String sentimental;

}
