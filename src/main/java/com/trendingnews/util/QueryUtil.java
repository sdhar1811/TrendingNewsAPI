package com.trendingnews.util;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.trendingnews.model.EventModel;
import com.trendingnews.model.LocationModel;

public class QueryUtil {

	public static void executeQuery(String query) {
		QueryExecution executor = QueryExecutionFactory.sparqlService(TrendingNewsConstants.SPARQL_SERVICE_ENDPOINTS,
				query);
		ResultSet resultSet = executor.execSelect();

		while (resultSet.hasNext()) {
			QuerySolution solution = resultSet.nextSolution();
			RDFNode subject = solution.get("?subject");
			if (subject == null) {
				System.out.println("NULL:" + solution.get("subject"));
			} else {
				System.out.println("subject:" + subject.toString());
			}

		}

	}

	public static List<String> fetchCities() {

		QueryExecution exe = QueryExecutionFactory.sparqlService(TrendingNewsConstants.SPARQL_SERVICE_ENDPOINTS,
				TrendingNewsConstants.PREFIX + TrendingNewsConstants.FETCH_CITY_LIST);

		ResultSet resultSet = exe.execSelect();
		ArrayList<String> cityList = new ArrayList<String>();

		while (resultSet.hasNext()) {
			QuerySolution solution = resultSet.nextSolution();
			RDFNode node = solution.get("?cityName");

			if (node != null) {
				cityList.add(node.toString());
			}

		}
		return cityList;

	}

	public static List<String> fetchEventCategories() {
		QueryExecution exe = QueryExecutionFactory.sparqlService(TrendingNewsConstants.SPARQL_SERVICE_ENDPOINTS,
				TrendingNewsConstants.PREFIX + TrendingNewsConstants.FETCH_EVENT_CATEGORIES);

		ResultSet resultSet = exe.execSelect();
		ArrayList<String> categoryList = new ArrayList<String>();

		// ResultSetFormatter.out(System.out,resultSet);
		while (resultSet.hasNext()) {
			QuerySolution solution = resultSet.nextSolution();
			RDFNode node = solution.get("?class");
			if (node != null) {
				categoryList.add(node.toString().substring(node.toString().lastIndexOf("#") + 1));
			}

		}

		return categoryList;

	}

	public static List<EventModel> getEventDetails(String keyWord) {
		String query = String.format(TrendingNewsConstants.FETCH_EVENT_DETAILS, keyWord);
		QueryExecution exe = QueryExecutionFactory.sparqlService(TrendingNewsConstants.SPARQL_SERVICE_ENDPOINTS,
				TrendingNewsConstants.PREFIX + query);

		ResultSet resultSet = exe.execSelect();
		ArrayList<EventModel> eventList = new ArrayList<EventModel>();

		// ResultSetFormatter.out(System.out, resultSet);
		String city = null;
		double score = 0.0;
		String pressSourceName = null;
		String locationURI = null;
		while (resultSet.hasNext()) {

			QuerySolution solution = resultSet.nextSolution();
			String category = solution.get("?eventCategory").toString();
			String content = solution.get("?content").toString();
			String date = solution.get("?dateTime").toString();

			RDFNode locNode = solution.get("?locationName");
			RDFNode locURINode = solution.get("?locationURI");
			RDFNode pressNode = solution.get("?pressSourceName");
			Literal scoreNode = solution.getLiteral("?score");

			if (locNode != null) {
				city = locNode.toString();
			}
			if (locURINode != null) {
				locationURI = locURINode.toString();
			}
			if (scoreNode != null) {
				score = scoreNode.getDouble();
			}
			if (pressNode != null) {
				pressSourceName = pressNode.toString();
			}

			Literal numberOfComments = solution.getLiteral("?numberOfComments");

			eventList.add(new EventModel(category.substring(category.lastIndexOf("#") + 1), content,
					date.substring(0, date.indexOf("^")), numberOfComments.getInt(), city, locationURI, pressSourceName,
					score));

		}

		return eventList;

	}

	public static LocationModel getLocationDetails(String cityId, String date) {

		String query = String.format(TrendingNewsConstants.FETCH_LOCATION_DETAILS, cityId, cityId, cityId,
				date.substring(0, date.indexOf("T")));
//		System.out.println(query);
		QueryExecution exe = QueryExecutionFactory.sparqlService(TrendingNewsConstants.SPARQL_SERVICE_ENDPOINTS,
				TrendingNewsConstants.PREFIX + query);

		ResultSet resultSet = exe.execSelect();
		LocationModel locationModel = null;
		//ResultSetFormatter.out(System.out, resultSet);
		while (resultSet.hasNext()) {
			QuerySolution solution = resultSet.nextSolution();
			String stateName = solution.get("?stateName").toString();
			String countyName = solution.get("?countyName").toString();
			int covidConfirmedCases = solution.getLiteral("?covidConfirmedCases").getInt();
			int covidDeaths = solution.getLiteral("?covidDeaths").getInt();
			String dateOutput= solution.getLiteral("?date").toString();
			double actualMaxTemp = solution.getLiteral("?actualMaxTemp").getDouble();
			double actualMinTemp = solution.getLiteral("?actualMinTemp").getDouble();
			double actualMeanTemp = solution.getLiteral("?actualMeanTemp").getDouble();
			double averageMaxTemp = solution.getLiteral("?averageMaxTemp").getDouble();
			double averageMinTemp = solution.getLiteral("?averageMinTemp").getDouble();
			double recordMaxTemp = solution.getLiteral("?recordMaxTemp").getDouble();
			double recordMinTemp = solution.getLiteral("?recordMinTemp").getDouble();

			double recordMaxTempYear = solution.getLiteral("?recordMaxTempYear").getDouble();
			double recordMinTempYear = solution.getLiteral("?recordMinTempYear").getDouble();
			double actualPercipitation = solution.getLiteral("?actualPrecipitation").getDouble();
			double averagePrecipitation = solution.getLiteral("?averagePrecipitation").getDouble();
			double recordPrecipitation = solution.getLiteral("?recordPrecipitation").getDouble();

			locationModel = new LocationModel(stateName, countyName, covidConfirmedCases, covidDeaths, dateOutput.substring(0,dateOutput.indexOf("T")), actualMaxTemp,
					actualMinTemp, actualMeanTemp, averageMaxTemp, averageMinTemp, recordMaxTemp, recordMinTemp,
					recordMaxTempYear, recordMinTempYear, actualPercipitation, averagePrecipitation,
					recordPrecipitation);

		}

		return locationModel;

	}
	
	public static List<EventModel> fetchEventListUsingFilter(String keyword, String location, String date, String category){
		String key="";
		String cityName="";
		String dateTemp="";
		String categoryTemp="";
				
		if(keyword!=null && !keyword.isEmpty()) {
			key=keyword;
		}
		if(location!=null && !location.isEmpty()) {
			cityName=location;
		}
		if(date!=null && !date.isEmpty()) {
			dateTemp = date;
		}
		if(category!=null && !category.isEmpty()) {
			categoryTemp=category;
		}
		
		String query = String.format(TrendingNewsConstants.FETCH_EVENT_BASED_ON_FILTER, key,cityName,dateTemp,categoryTemp);	
		
		
		System.out.println(query);
		QueryExecution exe = QueryExecutionFactory.sparqlService(TrendingNewsConstants.SPARQL_SERVICE_ENDPOINTS,
				TrendingNewsConstants.PREFIX + query);
		
		

		ResultSet resultSet = exe.execSelect();
		ArrayList<EventModel> eventList = new ArrayList<EventModel>();

		// ResultSetFormatter.out(System.out, resultSet);
		String city = null;
		double score = 0.0;
		String pressSourceName = null;
		String locationURI = null;
		while (resultSet.hasNext()) {

			QuerySolution solution = resultSet.nextSolution();
			String categoryResult = solution.get("?eventCategory").toString();
			String content = solution.get("?content").toString();
			String dateResult = solution.get("?dateTime").toString();

			RDFNode locNode = solution.get("?locationName");
			RDFNode locURINode = solution.get("?locationURI");
			RDFNode pressNode = solution.get("?pressSourceName");
			Literal scoreNode = solution.getLiteral("?score");

			if (locNode != null) {
				city = locNode.toString();
			}
			if (locURINode != null) {
				locationURI = locURINode.toString();
			}
			if (scoreNode != null) {
				score = scoreNode.getDouble();
			}
			if (pressNode != null) {
				pressSourceName = pressNode.toString();
			}

			Literal numberOfComments = solution.getLiteral("?numberOfComments");

			eventList.add(new EventModel(categoryResult.substring(categoryResult.lastIndexOf("#") + 1), content,
					dateResult.substring(0, dateResult.indexOf("^")), numberOfComments.getInt(), city, locationURI, pressSourceName,
					score));

		}

		return eventList;
	}
	
	

}
