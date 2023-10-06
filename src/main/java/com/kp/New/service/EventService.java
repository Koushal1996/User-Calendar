package com.kp.New.service;

import com.kp.New.entity.Event;
import com.kp.New.view.EventRequest;
import com.kp.New.view.EventResponse;

import java.util.List;

public interface EventService {

    public EventResponse saveEvent(EventRequest eventRequest);


    public List<EventResponse> findAllEvents();
}
