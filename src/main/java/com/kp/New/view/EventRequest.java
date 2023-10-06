package com.kp.New.view;

import com.kp.New.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public class EventRequest {

    private String title;

    private String startTime;

    private String endTime;

    private List<Long> participantIds;

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

    public List<Long> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<Long> participantIds) {
        this.participantIds = participantIds;
    }

    public Event toEntity(){
        Event event=new Event();
        event.setTitle(this.title);
        event.setStartTime(this.startTime);
        event.setEndTime(this.endTime);
        return event;
    }
}
