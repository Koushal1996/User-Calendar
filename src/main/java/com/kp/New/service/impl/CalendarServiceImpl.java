package com.kp.New.service.impl;

import com.kp.New.dao.CalendarDao;
import com.kp.New.entity.Calendar;
import com.kp.New.service.CalendarService;
import com.kp.New.view.CalendarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarDao calendarDao;


    @Override
    public Calendar save(CalendarRequest calendarRequest) {
        Calendar calendar=calendarDao.findByUserId(calendarRequest.getUserId());
        if(calendar==null) {
            calendar = calendarRequest.toEntity();
            calendar.setUserId(calendarRequest.getUserId());
        }else{
            calendar.setDescription(calendarRequest.getDescription());
            calendar.setUpdatedAt(LocalDateTime.now());
        }
        calendarDao.save(calendar);
        return calendar;
    }

    @Override
    public List<Calendar> findAll() {
        return calendarDao.findAll();
    }
}
