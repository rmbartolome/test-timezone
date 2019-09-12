package com.test.timezone.services;

import com.test.timezone.dto.TimeDTO;
import org.springframework.stereotype.Component;

import java.time.*;

@Component
public class TimezoneServices {

    public String getTimeZone(String hour, String timeZone){

        return parseTime(hour,timeZone).toString();
    }

    private TimeDTO parseTime(String hour, String timezone){

        LocalTime time
                = LocalTime.parse(hour);
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),time);
        ZoneId zoneLocal = ZoneId.of(timezone);
        ZonedDateTime zonedDateTimeLocal = localDateTime.atZone(zoneLocal);
        ZoneId zoneUTC = ZoneId.of("UTC");
        ZonedDateTime utcTime = zonedDateTimeLocal.withZoneSameInstant(zoneUTC);
        return new TimeDTO(hourFormat(utcTime), utcTime.getZone().toString().toLowerCase());
    }

    private String hourFormat( ZonedDateTime time){
        return time.getHour()+":"+time.getMinute()+":"+time.getSecond();
    }

}
