package com.adp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.db.CalendarDao;
import com.adp.db.model.Calendar;

@Service
@Transactional
public class CalendarService {
	
	@Autowired
	private CalendarDao calendarDao;
	
	
	public Calendar getCalendar(Long id) {
		return calendarDao.getCalendarById(id);
	}
	public List<Calendar> getCalendarListByUserId(Long userId) {
		return calendarDao.getCalendarByUserId(userId);
		
	}
	public Long create(Calendar calendar) {
		return calendarDao.create(calendar);
	}


}
