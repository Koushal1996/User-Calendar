package com.kp.New.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "participant_event")
public class CalendarEvent implements Serializable {

    @EmbeddedId
    public CalendarEventId calendarEventId;

    @MapsId("participantId")
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Calendar participant;

    @MapsId("eventId")
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public CalendarEvent() {
    }

    public CalendarEvent(Long eventId,Long participantId){
        super();
        this.participant=new Calendar();
        this.participant.setId(participantId);
        this.event=new Event();
        this.event.setId(eventId);
        this.calendarEventId=new CalendarEventId();
        this.calendarEventId.setEventId(eventId);
        this.calendarEventId.setParticipantId(participantId);
    }

    public CalendarEventId getCalendarEventId() {
        return calendarEventId;
    }

    public void setCalendarEventId(CalendarEventId calendarEventId) {
        this.calendarEventId = calendarEventId;
    }

    public Calendar getParticipant() {
        return participant;
    }

    public void setParticipant(Calendar participant) {
        this.participant = participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
