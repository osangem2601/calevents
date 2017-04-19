package com.adp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adp.db.model.Calendar;

@Repository
public class CalendarDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long create(Calendar calendar) 	{
		entityManager.persist(calendar);
		entityManager.flush();
		return calendar.getId();
	}
	
	public Calendar getCalendarById(Long id) {
		return entityManager.find(Calendar.class, id);
	}
	
	public List<Calendar> getCalendarByUserId(Long id) {
		
		Query query = entityManager.createQuery("from Calendar cal where cal.user.id = :userId");
		query.setParameter("userId", id);
		List<Calendar> calendarList = (List<Calendar>)query.getResultList();
		return calendarList;
	}

	public void update(Calendar calendar) {
		entityManager.merge(calendar);		
	}

}
