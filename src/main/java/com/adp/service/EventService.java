package com.adp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.db.EventDao;
import com.adp.db.model.Event;

@Service
@Transactional
public class EventService {
	
	@Autowired
	private EventDao eventDao;
	
	public Event getEvent(Long id) {		
		return eventDao.getEvent(id);
	}
	public List<Event> getEventsByCalendarId(Long calId) {		
		return eventDao.getEventsByCalendarId(calId);
	}
		
	public Long creatEvent(Event event) {		
		return eventDao.creatEvent(event);
	}
	
	public void updateEvent(Event event) {		
		eventDao.updateEvent(event);
	}
	
	public void deleteEvent(Long id) {		
		eventDao.deleteEvent(id);
	}

}
