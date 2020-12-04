package com.trendingnews.util;

public class TrendingNewsConstants {

	public static String SPARQL_SERVICE_ENDPOINTS = "http://35.193.89.92:3030/team18ontology/query";
//	public static String SPARQL_SERVICE_ENDPOINTS = "http://localhost:3030/test/query";

	public static String FETCH_CITY_LIST = "SELECT ?cityName " + "WHERE {" + "  ?city a team18:City. "
			+ "  ?city team18:locationName ?cityName." + "}";

	public static String PREFIX = "PREFIX team18: <http://www.semanticweb.org/team18#> "
			+ "prefix owl: <http://www.w3.org/2002/07/owl#> " + "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
			+ " PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> ";

	public static String FETCH_EVENT_CATEGORIES = "SELECT ?class " + "WHERE {" + "  ?class a owl:Class." + "  {"
			+ "    ?class rdfs:subClassOf team18:SocialMediaNews." + "  }" + "  UNION " + "  {"
			+ "    ?class rdfs:subClassOf team18:Reddit." + "  } " + "  FILTER(?class != team18:Reddit)" + "}";

	public static String FETCH_EVENT_DETAILS =

			"SELECT ?eventCategory ?content ?locationType ?dateTime ?numberOfComments ?locationName ?locationURI ?pressSourceName ?score "
					+ "WHERE {" + "  ?event rdf:type ?eventCategory."
					+ "  ?eventCategory rdfs:subClassOf* team18:SocialMediaNews." + "  ?event team18:content ?content."
					+ "  OPTIONAL{" + "    ?event team18:hasLocation ?locationURI."
					+ "    ?locationURI rdf:type ?locationType." + "    ?locationURI team18:locationName ?locationName."
					+ "    FILTER(?locationType != owl:NamedIndividual)" + "  }" + "  ?event team18:dateTime ?dateTime."
					+ "  ?event team18:numberOfComments ?numberOfComments. " + "  OPTIONAL {"
					+ "    ?event ?hasPressSource ?pressSource."
					+ "    ?pressSource team18:sourceName ?pressSourceName." + "  } " + "  OPTIONAL {"
					+ "    ?event ?scoreType ?score." + "    ?scoreType rdfs:subPropertyOf* team18:score."
					+ "    FILTER(?scoreType != team18:negativeScore)" + "  } " + "  "
					+ "  FILTER CONTAINS(str(?content), \"%s\") " + "} " + "" + "ORDER BY DESC (?numberOfComments)";

	public static String FETCH_LOCATION_DETAILS =
			
			"SELECT ?stateName ?countyName ?covidConfirmedCases ?covidDeaths ?date ?actualMaxTemp ?actualMinTemp ?actualMeanTemp ?averageMaxTemp ?averageMinTemp ?recordMaxTemp ?recordMinTemp ?recordMaxTempYear ?recordMinTempYear ?actualPrecipitation ?averagePrecipitation ?recordPrecipitation "
			+ "WHERE { " + "  team18:%s team18:isInState ?state. " + "  ?state team18:locationName ?stateName. "
			+ "  team18:%s team18:isInCounty ?county. " + "  ?county team18:locationName ?countyName. "
			+ "  ?covid a team18:Covid. " + "  ?covid team18:hasLocation ?county. "
			+ "  ?covid team18:deathCount ?covidDeaths. " + "  ?covid team18:caseCount ?covidConfirmedCases. "
			+ "  ?covid team18:dateTime ?date. " + "  ?weather a team18:Weather. "
			+ "  ?weather team18:dateTime ?date. " + "  ?weather team18:hasLocation team18:%s. "
			+ "  ?weather team18:actualMaxTemp ?actualMaxTemp. " + "  ?weather team18:actualMinTemp ?actualMinTemp. "
			+ "  ?weather team18:actualMeanTemp ?actualMeanTemp. "
			+ "  ?weather team18:averageMaxTemp ?averageMaxTemp. "
			+ "  ?weather team18:averageMinTemp ?averageMinTemp. " + "  ?weather team18:recordMaxTemp ?recordMaxTemp. "
			+ "  ?weather team18:recordMinTemp ?recordMinTemp. "
			+ "  ?weather team18:recordMaxTempYear ?recordMaxTempYear. "
			+ "  ?weather team18:recordMinTempYear ?recordMinTempYear. "
			+ "  ?weather team18:actualPrecipitation ?actualPrecipitation. "
			+ "  ?weather team18:averagePrecipitation ?averagePrecipitation. "
			+ "  ?weather team18:recordPrecipitation ?recordPrecipitation. " + " "
			+ "  FILTER (contains(xsd:string(?date),\"%s\")) " + "} ";
	
	public static String FETCH_EVENT_BASED_ON_FILTER =
			
			"SELECT ?eventCategory ?content ?locationType ?dateTime ?numberOfComments ?locationName ?locationURI ?pressSourceName ?score " + 
			"WHERE { " + 
			"  ?event rdf:type ?eventCategory. " + 
			"  ?eventCategory rdfs:subClassOf* team18:SocialMediaNews. " + 
			"  ?event team18:content ?content. " + 
			"  ?event team18:hasLocation ?locationURI. " + 
			"  ?locationURI rdf:type ?locationType.  " + 
			"  ?locationURI team18:locationName ?locationName. " + 
			"  ?event team18:dateTime ?dateTime. " + 
			"  ?event team18:numberOfComments ?numberOfComments. " + 
			"  OPTIONAL { " + 
			"    ?event ?hasPressSource ?pressSource. " + 
			"    ?pressSource team18:sourceName ?pressSourceName. " + 
			"  } " + 
			"  OPTIONAL { " + 
			"    ?event ?scoreType ?score. " + 
			"    ?scoreType rdfs:subPropertyOf* team18:score. " + 
			"    FILTER(?scoreType != team18:negativeScore) " + 
			"  }  " + 
			"   " + 
			"  FILTER CONTAINS(str(?content), \"%s\")  " + 
			"  FILTER CONTAINS(str(?locationName), \"%s\") " + 
			"  FILTER CONTAINS(str(?dateTime), \"%s\")  " + 
			"  FILTER CONTAINS(str(?eventCategory), \"%s\")  " + 
			"  FILTER(?locationType != owl:NamedIndividual) " + 
			"} " + 
			" " + 
			"ORDER BY DESC (?numberOfComments) "; 
			
	

}
