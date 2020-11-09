package com.aplha.elephant.twilio.demo.reviews;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("reviews")
@EnableConfigurationProperties
public class GooglePlacesApiConfiguration {

    private String googleAuthKey;

    public GooglePlacesApiConfiguration() {

    }

    public String getGoogleAuthKey() {
        return googleAuthKey;
    }

    public void setGoogleAuthKey(String googleAuthKey) {
        this.googleAuthKey = googleAuthKey;
    }
}
