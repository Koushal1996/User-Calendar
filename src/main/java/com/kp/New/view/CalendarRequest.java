package com.kp.New.view;

import com.kp.New.entity.Calendar;

import java.time.LocalDateTime;

public class CalendarRequest {

    private String description;

    private Long userId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Calendar toEntity(){
        Calendar calendar=new Calendar();
        calendar.setDescription(this.description);
        calendar.setCreatedAt(LocalDateTime.now());
        return calendar;
    }
}
