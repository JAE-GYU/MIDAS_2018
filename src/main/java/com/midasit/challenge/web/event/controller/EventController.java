package com.midasit.challenge.web.event.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midasit.challenge.web.event.dao.EventDao;
import com.midasit.challenge.web.event.model.Event;
import com.midasit.challenge.web.event.service.EventService;
import com.midasit.challenge.web.util.cmd.CMD;
import com.midasit.challenge.web.util.format.ResponseFormat;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private EventService eventService;
	
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping
	public ResponseFormat<List<Event>> list(){
		List<Event> eventList = eventDao.findAll();
		ResponseFormat<List<Event>> format = new ResponseFormat<List<Event>>(eventList);
		if(eventList == null){
			format.setDescription(CMD.description(CMD.LIST));
			format.setCode(-1);
	    }
		return format;
	}
	
	@GetMapping("/{id}")
	public ResponseFormat<Event> view(@PathVariable int id) {
		Event event = eventDao.getOne(id);
		ResponseFormat<Event> format = new ResponseFormat<Event>(event);
		if(event != null) {
			format.setDescription(CMD.description(CMD.VIEW));
		}
		return new ResponseFormat<Event>(event);
	}

	@PostMapping
	public ResponseFormat<Event> add(@RequestBody Event event) {
		eventDao.save(event);
		ResponseFormat<Event> format = new ResponseFormat<Event>();
		if(event == null) {
			format.setDescription(CMD.description(CMD.INSERT));
		}
		return format;
	}
	
	@DeleteMapping({"/{id}"})
	public ResponseFormat<Event> delete(@PathVariable int id) {
		eventDao.deleteById(id);
		ResponseFormat format = new ResponseFormat();
		format.setDescription(CMD.description(CMD.DELETE));
		return format;
	}
	
	@PutMapping
    private ResponseFormat<Event> update(@RequestBody Event event) throws Exception{
		System.out.println(event.getStart_date());
        eventService.updateEvent(event);
        ResponseFormat<Event> responseFormat = new ResponseFormat<Event>(event);
        return responseFormat;
    }
}
