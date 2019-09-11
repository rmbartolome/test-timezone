package com.test.timezone.services;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimezoneServices {

    public Date getTimeZone(){

        return new Date();
    }

}
