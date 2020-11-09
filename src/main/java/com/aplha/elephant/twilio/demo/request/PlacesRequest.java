package com.aplha.elephant.twilio.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PlacesRequest {

    public PlacesRequest(String placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "PlacesRequest{" +
                "placeId='" + placeId + '\'' +
                '}';
    }

    @JsonProperty("placeId")
    @NotBlank
    private final String placeId;

    public String getPlaceId() {
        return placeId;
    }

}
