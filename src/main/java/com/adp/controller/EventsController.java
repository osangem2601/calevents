package com.adp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adp.db.model.Calendar;
import com.adp.db.model.Event;
import com.adp.service.CalendarService;
import com.adp.service.EventService;

@RestController
@RequestMapping(value="/user/{userId}/calendar/{calId}/events")
public class EventsController {

	@Autowired
    private CalendarService calendarService;
	
	@Autowired
	private EventService eventService;
    
    private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
    
    @RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Event>> getEventList(@PathVariable Long calId)
	{
		logger.info("Get events list request");
    	List<Event> eventsList = eventService.getEventsByCalendarId(calId);  
    	if(eventsList == null) {    		
    		return ResponseEntity.notFound().build();    		
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.FOUND).body(eventsList);	
    	}
	}
    
	@RequestMapping(value="/{eventId}", method=RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable Long eventId)
	{
		logger.info("Get event request");
    	Event event = eventService.getEvent(eventId);  
    	if(event == null) {    		
    		return ResponseEntity.notFound().build();    		
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.FOUND).body(event);	
    	}
	}
    
	@RequestMapping(value="/{eventId}", method=RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Long eventId)
	{
		logger.info("Get event request");
    	eventService.deleteEvent(eventId);  
    	
    	return ResponseEntity.status(HttpStatus.OK).build();	
    	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<HttpStatus> creatEvent(@PathVariable Long calId, @RequestBody Event event)
	{
		logger.info("Create event request");
    	logger.info("Event name :" + event.getTitle());    	
    	
    	
    	Calendar calendar = calendarService.getCalendar(calId);
    	event.setCalendar(calendar);
    	Long id = eventService.creatEvent(event);
    	logger.info("Event created with id:" + id);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<HttpStatus> updateEvent(@PathVariable Long calId, @RequestBody Event event)
	{
		logger.info("Update event request");
    	logger.info("Event name :" + event.getTitle());    	
    	Calendar calendar = calendarService.getCalendar(calId);
    	event.setCalendar(calendar);
    	eventService.updateEvent(event);
    	return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
