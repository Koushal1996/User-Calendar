package com.kp.New.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@DynamicUpdate
@DynamicInsert
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String startTime;

    private String endTime;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "participant")
    private List<CalendarEvent> participantEvents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CalendarEvent> getParticipantEvents() {
        return participantEvents;
    }

    public void setParticipantEvents(List<CalendarEvent> participantEvents) {
        this.participantEvents = participantEvents;
    }
}
