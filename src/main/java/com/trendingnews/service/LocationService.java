package com.trendingnews.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.trendingnews.model.LocationModel;
import com.trendingnews.util.QueryUtil;

@Service
public class LocationService {

	public List<String> getAllCities() {
		return QueryUtil.fetchCities();
		
	}

	public LocationModel getLocationDetails(String locationURI, String date) {		
		return QueryUtil.getLocationDetails(locationURI,date);
	}

}
