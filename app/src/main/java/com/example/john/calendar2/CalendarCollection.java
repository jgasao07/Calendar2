package com.example.john.calendar2;

import java.util.ArrayList;

public class CalendarCollection {
    public String date = "";
    public String eventName = "";
    public String time = "";
    public String location = "";
    public String description = "";

    public static ArrayList<CalendarCollection> date_collection_arr = new ArrayList<>();

    public CalendarCollection(String eventName,String date, String time, String location,
                              String description){
        this.date=date;
        this.eventName=eventName;
        this.time=time;
        this.location=location;
        this.description=description;
    }
}
