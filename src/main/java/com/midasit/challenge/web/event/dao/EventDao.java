package com.midasit.challenge.web.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midasit.challenge.web.event.model.Event;

public interface EventDao extends JpaRepository<Event, Integer> {

}
