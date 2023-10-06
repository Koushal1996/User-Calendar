package com.kp.New.controller;

import com.kp.New.entity.Calendar;
import com.kp.New.service.CalendarService;
import com.kp.New.view.CalendarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @PostMapping("/calendar")
    public ResponseEntity<Calendar> saveOrUpdate(@RequestBody CalendarRequest calendarRequest){
        return ResponseEntity.ok(calendarService.save(calendarRequest));
    }

    @GetMapping("/calendars")
    public List<Calendar> findAll(){
        return calendarService.findAll();
    }
}
