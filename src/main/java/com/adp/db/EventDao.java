package com.adp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adp.db.model.Event;

@Repository
public class EventDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Event getEvent(Long id) {		
		return entityManager.find(Event.class, id);
	}
		
	public List<Event> getEventsByCalendarId(Long calId) {
		
		Query query = entityManager.createQuery("from Event event where event.calendar.id = :calId");
		query.setParameter("calId", calId);
		List<Event> eventList = (List<Event>)query.getResultList();
		return eventList;
	}
	
	public Long creatEvent(Event event) {		
		entityManager.persist(event);
		entityManager.flush();
		return event.getId();
	}
	
	public void updateEvent(Event event) {		
		entityManager.merge(event);
	}
	
	public void deleteEvent(Long id) {		
		entityManager.remove(getEvent(id));
	}


}
