package com.adp.db.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Event {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Calendar calendar;
	
	private String title;	
	
	private Date eventDate;	
	private Time eventTime;	
	private String location;	
	private String attendeeList;	
	private Time reminderTime;	
	private boolean reminderSent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public Time getEventTime() {
		return eventTime;
	}
	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAttendeeList() {
		return attendeeList;
	}
	public void setAttendeeList(String attendeeList) {
		this.attendeeList = attendeeList;
	}
	public Time getReminderTime() {
		return reminderTime;
	}
	public void setReminderTime(Time reminderTime) {
		this.reminderTime = reminderTime;
	}
	public boolean isReminderSent() {
		return reminderSent;
	}
	public void setReminderSent(boolean reminderSent) {
		this.reminderSent = reminderSent;
	}
}
