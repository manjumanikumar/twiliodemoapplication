package com.aplha.elephant.twilio.demo.sms;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsSenderImpl implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSenderImpl.class);

    @Autowired
    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSenderImpl(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {

        if (isPhoneNumberValid(smsRequest.getPhoneNumber())){
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();

            LOGGER.info("SMS successfully sent with message : {} ", message);
        }
        else {
            throw new IllegalArgumentException("Phone Number Invalid");
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        //TODO
        return true;
    }
}
