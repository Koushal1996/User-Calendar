package com.kp.New.dao;

import com.kp.New.entity.Calendar;
import com.kp.New.view.CalendarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface CalendarDao extends JpaRepository<Calendar,Long> {

    @Query(value = "select * from calendar where user_id=?1",nativeQuery = true)
    public Calendar findByUserId(Long userId);
}
