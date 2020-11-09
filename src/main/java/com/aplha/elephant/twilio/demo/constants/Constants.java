package com.aplha.elephant.twilio.demo.constants;

public class Constants {

    public static String GOOGLE_URL = "https://maps.googleapis.com/maps/api/place/details/json?placeid={place_id}&key={api_key}";

    public static final String TOP_LEVEL_REVIEW_ROUTE = "direct:topLevelReviewRoute";

    public static final String PLACE_ID = "place_id";

    public static final String SERVICE_ENDPOINT_HEADER_KEY = "serviceEndpoint";

    public static final String EXCHANGE_HEADER_SERVICE_ENDPOINT = String.format("${header.%s}", SERVICE_ENDPOINT_HEADER_KEY);
}
