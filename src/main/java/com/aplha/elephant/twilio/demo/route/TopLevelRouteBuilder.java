package com.aplha.elephant.twilio.demo.route;

import com.aplha.elephant.twilio.demo.pojo.Places;
import com.aplha.elephant.twilio.demo.reviews.GooglePlacesApiConfiguration;
import com.aplha.elephant.twilio.demo.reviews.GoogleReviewsImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.http.HeaderElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import static com.aplha.elephant.twilio.demo.constants.Constants.*;

@Component
public class TopLevelRouteBuilder extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopLevelRouteBuilder.class);

    @Autowired
    private GooglePlacesApiConfiguration googlePlacesApiConfiguration;

    @Autowired
    private GoogleReviewsImpl googleReviews;

    @Override
    public void configure() throws Exception {
        googleReviewRoute();
    }

    private void googleReviewRoute() {
        from(TOP_LEVEL_REVIEW_ROUTE).routeId("googleReviewRoute")
                .setProperty(PLACE_ID, header(PLACE_ID))
                .setHeader(SERVICE_ENDPOINT_HEADER_KEY, method(this, "getUpdatedUrl"))
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .toD(EXCHANGE_HEADER_SERVICE_ENDPOINT)
                .convertBodyTo(String.class)
                .log(LoggingLevel.INFO, "Response of the call is " + "This class" + String.valueOf(simple("${in.body}")))
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        LOGGER.info("INBODY ----------------" + exchange.getIn().getBody(String.class));
                    }
                })
        .bean(this, "convertToPlaces");
    }

    public String getUpdatedUrl(@ExchangeProperty(PLACE_ID) String place_id) {
        return GOOGLE_URL.replace("{api_key}", googlePlacesApiConfiguration.getGoogleAuthKey()).replace("{place_id}", place_id);
    }

    public Places convertToPlaces(@Body String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(body, Places.class);
    }
}
