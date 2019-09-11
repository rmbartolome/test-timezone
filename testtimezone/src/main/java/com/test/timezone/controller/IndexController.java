package com.test.timezone.controller;


import com.test.timezone.services.TimezoneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private TimezoneServices timezoneServices;

    @GetMapping
    public String sayHello() {
        return "Hello and Welcome to my app.";
    }

    @GetMapping("/get")
    public ResponseEntity getTimeZone(@RequestParam String hour, @RequestParam String timezone) {

        //return new ResponseEntity(convertLocalTimeToUTC(timezone,hour), HttpStatus.OK);
        return new ResponseEntity(timezoneServices.getTimeZone(), HttpStatus.OK);
    }

    public static String convertLocalTimeToUTC(String p_city, String p_localDateTime){

        String lv_dateFormateInUTC="";//Will hold the final converted date
        Date lv_localDate = null;
        String lv_localTimeZone ="";
        SimpleDateFormat lv_formatter;
        SimpleDateFormat lv_parser;

        //create a new Date object using the timezone of the specified city
        lv_parser = new SimpleDateFormat("HH:mm:ss");
        lv_parser.setTimeZone(TimeZone.getTimeZone("GMT"+p_city));
        try {
            lv_localDate = lv_parser.parse(p_localDateTime);
            lv_formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            lv_formatter.setTimeZone(TimeZone.getTimeZone(lv_localTimeZone));

            System.out.println("convertLocalTimeToUTC: "+p_city+": "+" The Date in the local time zone " + lv_formatter.format(lv_localDate));

            //Convert the date from the local timezone to UTC timezone
            lv_formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            lv_dateFormateInUTC = lv_formatter.format(lv_localDate);
            System.out.println("convertLocalTimeToUTC: "+p_city+": "+" The Date in the UTC time zone " + lv_dateFormateInUTC);
        } catch ( ParseException e ) {
            e.printStackTrace();
        }
        return lv_dateFormateInUTC;
    }
}
