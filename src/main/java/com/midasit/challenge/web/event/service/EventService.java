package com.midasit.challenge.web.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midasit.challenge.web.event.mapper.EventMapper;
import com.midasit.challenge.web.event.model.Event;


@Service
public class EventService {
	@Autowired
	EventMapper eventMapper;
	
	public void updateEvent(Event event) throws Exception {
		eventMapper.updateEvent(event);
	}
}
