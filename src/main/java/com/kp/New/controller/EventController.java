package com.kp.New.controller;

import com.kp.New.entity.Event;
import com.kp.New.service.EventService;
import com.kp.New.view.EventRequest;
import com.kp.New.view.EventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/event")
    public ResponseEntity<EventResponse> saveEvent(@RequestBody EventRequest eventRequest){
        return ResponseEntity.ok(eventService.saveEvent(eventRequest));
    }

    @GetMapping("/events")
    public List<EventResponse> findAllEvents(){
        return eventService.findAllEvents();
    }
}
