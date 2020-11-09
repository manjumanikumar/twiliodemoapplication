package com.aplha.elephant.twilio.demo.reviews;


import com.aplha.elephant.twilio.demo.pojo.Places;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class GooglePlacesApiService {

    @Autowired
    private Reviews googleReviews;

    public Places review(String placeId) {
       return googleReviews.getReviews(placeId);
    }
}
