package com.kp.New.dao;

import com.kp.New.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Tuple;
import java.util.List;

public interface EventDao extends JpaRepository<Event,Long> {


}
