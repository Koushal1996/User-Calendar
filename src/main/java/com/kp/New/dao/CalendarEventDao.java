package com.kp.New.dao;

import com.kp.New.entity.CalendarEvent;
import com.kp.New.entity.CalendarEventId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface CalendarEventDao extends JpaRepository<CalendarEvent, CalendarEventId> {

    @Query(value = "select event_id as eventId,participant_id as participantId from participant_Event",nativeQuery = true)
    public List<Tuple> findParticipantEventIds();
}
