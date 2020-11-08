package com.aplha.elephant.twilio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/sms")
public class MessageSenderController {

    @Autowired
    private final MessageSenderService messageSenderService;

    public MessageSenderController(MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        messageSenderService.sendSms(smsRequest);
    }

}
