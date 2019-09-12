package com.test.timezone.dto;

public class TimeDTO {

    public TimeDTO(String time, String timezone) {
        this.time = time;
        this.timezone = timezone;
    }

    private String time;
    private String timezone;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "{  \"response\":{" +
                "\"time\":'" + time + '\'' +
                ", \"timezone\":'" + timezone + '\'' +
                '}';
    }
}
