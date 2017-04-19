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
import com.adp.service.CalendarService;
import com.adp.service.UserService;

@RestController
@RequestMapping(value="/user/{userId}/calendar")
public class CalendarController {
	
	@Autowired
    private CalendarService calendarService;
	@Autowired
	private UserService userService;
    
    private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
    
    @RequestMapping(method =RequestMethod.GET)
    public ResponseEntity<List<Calendar>>  getCalendarList(@PathVariable Long userId)
    {
    	logger.info("Get calendar list request by user id"+ userId);
    	List<Calendar> calendarList =  calendarService.getCalendarListByUserId(userId);    
    	if(calendarList == null) {    		
    		return ResponseEntity.notFound().build();    		
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.FOUND).body(calendarList);	
    	}
    }
    
    @RequestMapping(value="/{id}", method =RequestMethod.GET)
    public ResponseEntity<Calendar>  getCalendar(@PathVariable Long id)
    {
    	logger.info("Get calendar request by id:" + id);
    	Calendar calendar =  calendarService.getCalendar(id);    
    	if(calendar == null) {    		
    		return ResponseEntity.notFound().build();    		
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.FOUND).body(calendar);	
    	}
    }
	
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<HttpStatus> creatCalendar(@PathVariable Long userId, @RequestBody Calendar calendar)
    {
    	logger.info("Create calendar request");
    	logger.info("Calendar name :" + calendar.getName());    	
    	calendar.setUser(userService.getUser(userId));
    	
    	Long id  = calendarService.create(calendar);
    	logger.info("Calendar created with id:" + id);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).build();
   
    }

}
