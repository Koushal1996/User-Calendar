package com.kp.New.service;

import com.kp.New.entity.Calendar;
import com.kp.New.view.CalendarRequest;

import java.util.List;

public interface CalendarService {

    public Calendar save(CalendarRequest calendarRequest);

    public List<Calendar> findAll();
}
