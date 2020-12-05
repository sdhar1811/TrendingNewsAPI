package com.trendingnews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trendingnews.model.EventModel;
import com.trendingnews.model.LocationModel;
import com.trendingnews.service.EventService;
import com.trendingnews.service.LocationService;

@RestController
@CrossOrigin(origins = "*")
public class TrendingNewsController {

	@Autowired
	LocationService locationService;

	@Autowired
	EventService eventService;

	
	@GetMapping("/test")
	public String testMethod() {
		return "This is a test response which confirms that the API is working fine";
	}
	@GetMapping("/getAllCities")
	public List<String> getAllCities() {
		return this.locationService.getAllCities();
	}

	@GetMapping("/getEventCategory")
	public List<String> getEventCategories() {
		return this.eventService.getEventCategories();
	}

	@GetMapping("/search/event")
	public List<EventModel> getEventDetails(@RequestParam String keyword) {
		return this.eventService.getEventDetails(keyword);
	}

	@GetMapping("/search/location")
	public LocationModel getLocationDetails(@RequestParam String date, @RequestParam String cityId) {
		return this.locationService.getLocationDetails(cityId, date);
	}

	@GetMapping("/search/event/filter")
	public List<EventModel> getFilteredEventDetails(@RequestParam String date, @RequestParam String cityName,
			@RequestParam String keyword, @RequestParam String category) {
		return this.eventService.getFilteredEventDetails(keyword, cityName, date, category);
	}

}
