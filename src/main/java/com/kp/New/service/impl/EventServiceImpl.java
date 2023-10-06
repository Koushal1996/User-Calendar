package com.kp.New.service.impl;

import com.kp.New.dao.CalendarDao;
import com.kp.New.dao.CalendarEventDao;
import com.kp.New.dao.EventDao;
import com.kp.New.entity.Calendar;
import com.kp.New.entity.CalendarEvent;
import com.kp.New.entity.Event;
import com.kp.New.service.EventService;
import com.kp.New.view.CalendarResponse;
import com.kp.New.view.EventRequest;
import com.kp.New.view.EventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eventServiceImpl")
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private CalendarDao calendarDao;

    @Autowired
    private CalendarEventDao calendarEventDao;

    private Map<Long, CalendarResponse> getParticipantsLookup(){
        Map<Long,CalendarResponse> calendarLookup=new HashMap<>();
        List<Calendar> calendars=calendarDao.findAll();
        for(Calendar calendar:calendars){
            calendarLookup.putIfAbsent(calendar.getId(),new CalendarResponse(calendar.getId(),calendar.getDescription(),calendar.getUser().getName(),calendar.getUser().getId()));
        }
        return calendarLookup;
    }

    @Override
    public EventResponse saveEvent(EventRequest eventRequest) {
        Event event=eventRequest.toEntity();
        eventDao.save(event);
        EventResponse response=EventResponse.get(event);
        response.setParticipants(new ArrayList<>());
        List<CalendarEvent> participants=new ArrayList<>();
        eventRequest.getParticipantIds().forEach(id->{
            participants.add(new CalendarEvent(event.getId(),id));
            Calendar calendar=calendarDao.findById(id).get();
            response.getParticipants().add(new CalendarResponse(calendar.getId(),calendar.getDescription(),calendar.getUser().getName(),calendar.getUser().getId()));
        });
        calendarEventDao.saveAll(participants);
        return response;
    }


    @Override
    public List<EventResponse> findAllEvents() {
        List<EventResponse> response=new ArrayList<>();
        List<Event> events=eventDao.findAll();
        List<Tuple> participantEventIds=calendarEventDao.findParticipantEventIds();
        Map<Long,List<Long>> eventParticipantIds=new HashMap<>();
        Map<Long,CalendarResponse> participantLookup=getParticipantsLookup();
        participantEventIds.forEach(tuple->{
            eventParticipantIds.computeIfAbsent(tuple.get("eventId", BigInteger.class).longValue(),(participantIds)->new ArrayList<>()).add(tuple.get("participantId",BigInteger.class).longValue());
        });
        for(Event event:events){
            EventResponse eventResponse=EventResponse.get(event);
            eventResponse.setParticipants(new ArrayList<>());
            for(Long participantId:eventParticipantIds.get(event.getId())){
                eventResponse.getParticipants().add(participantLookup.get(participantId));
            }
            response.add(eventResponse);
        }
        return response;
    }
}
