package com.aplha.elephant.twilio.demo.reviews;

import com.aplha.elephant.twilio.demo.pojo.Places;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GooglePlaceApiController {

    @Autowired
    private GooglePlacesApiService googlePlacesApiService;

    @GetMapping(value = "api/v1/getReviews/{placeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Places> getGoogleReviews(@PathVariable String placeId) {

        Places places = googlePlacesApiService.review(placeId);

        return new ResponseEntity(places, org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_OK));
    }

}
