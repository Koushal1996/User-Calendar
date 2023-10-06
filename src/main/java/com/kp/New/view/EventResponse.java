package com.kp.New.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kp.New.entity.Event;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class EventResponse {

    private String title;

    private String startTime;

    private String endTime;

    private List<CalendarResponse> participants;

    public EventResponse(String title, String startTime, String endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<CalendarResponse> getParticipants() {
        return participants;
    }

    public void setParticipants(List<CalendarResponse> participants) {
        this.participants = participants;
    }

    public static EventResponse get(Event event){
        if(event!=null){
            return new EventResponse(event.getTitle(),event.getStartTime(),event.getEndTime());
        }
        return null;
    }
}
