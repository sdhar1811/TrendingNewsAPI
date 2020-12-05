package com.trendingnews.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trendingnews.model.EventModel;
import com.trendingnews.util.QueryUtil;

@Service
public class EventService {

	public List<String> getEventCategories() {
		
		return QueryUtil.fetchEventCategories();
	}

	public List<EventModel> getEventDetails(String keyword) {
		return QueryUtil.getEventDetails(keyword);
		
	}
	
	public List<EventModel> getFilteredEventDetails(String keyword, String location, String date, String category){
		return QueryUtil.fetchEventListUsingFilter(keyword, location, date, category);
	}
	

	
	

}
