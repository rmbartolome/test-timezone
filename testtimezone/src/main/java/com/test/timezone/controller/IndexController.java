package com.test.timezone.controller;


import com.test.timezone.services.TimezoneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value="/get")
    public String getTimeZone(@RequestParam String hour, @RequestParam String timezone) {
        return timezoneServices.getTimeZone(hour,timezone).toString();
    }
}
