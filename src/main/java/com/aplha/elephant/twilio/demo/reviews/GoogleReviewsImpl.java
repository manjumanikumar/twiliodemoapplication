package com.aplha.elephant.twilio.demo.reviews;

import com.aplha.elephant.twilio.demo.pojo.Places;
import com.aplha.elephant.twilio.demo.route.TopLevelRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.engine.DefaultProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.aplha.elephant.twilio.demo.constants.Constants.*;

@Component
@Service
public class GoogleReviewsImpl implements Reviews {

    @Produce(uri = TOP_LEVEL_REVIEW_ROUTE)
    private ProducerTemplate googleReviewProducer;

    @Override
    public Places getReviews(String placeId) {

        Map<String, Object> headerMap = new HashMap<>();

        headerMap.put(PLACE_ID, placeId);

        return googleReviewProducer.requestBodyAndHeaders(TOP_LEVEL_REVIEW_ROUTE, PLACE_ID, headerMap, Places.class);
    }
}
