package com.midasit.challenge.web.event.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.midasit.challenge.web.event.model.Event;

@Mapper
public interface EventMapper {
	public void updateEvent(Event event) throws Exception;
}
