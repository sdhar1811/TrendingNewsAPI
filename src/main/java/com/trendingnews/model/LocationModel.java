package com.trendingnews.model;

public class LocationModel {

	
	private String stateName;
	private String countyName;
	private int covidConfirmedCases;
	private int covidDeaths;
	private String date;
	private double actualMaxTemp;
	private double actualMinTemp;
	private double actualMeanTemp;
	private double averageMaxTemp;
	private double averageMinTemp;
	private double recordMaxTemp;
	private double recordMinTemp;

	private double recordMaxTempYear;
	private double recordMinTempYear;
	private double actualPercipitation;
	private double averagePrecipitation;
	private double recordPrecipitation;

	public LocationModel() {

	}

	public LocationModel(String stateName, String countyName, int covidConfirmedCases, int covidDeaths,
			String date, double actualMaxTemp, double actualMinTemp, double actualMeanTemp, double averageMaxTemp,
			double averageMinTemp, double recordMaxTemp, double recordMinTemp, double recordMaxTempYear,
			double recordMinTempYear, double actualPercipitation, double averagePrecipitation,
			double recordPrecipitation) {
		super();
		this.stateName = stateName;
		this.countyName = countyName;
		this.covidConfirmedCases = covidConfirmedCases;
		this.covidDeaths = covidDeaths;
		this.date = date;
		this.actualMaxTemp = actualMaxTemp;
		this.actualMinTemp = actualMinTemp;
		this.actualMeanTemp = actualMeanTemp;
		this.averageMaxTemp = averageMaxTemp;
		this.averageMinTemp = averageMinTemp;
		this.recordMaxTemp = recordMaxTemp;
		this.recordMinTemp = recordMinTemp;
		this.recordMaxTempYear = recordMaxTempYear;
		this.recordMinTempYear = recordMinTempYear;
		this.actualPercipitation = actualPercipitation;
		this.averagePrecipitation = averagePrecipitation;
		this.recordPrecipitation = recordPrecipitation;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public int getCovidConfirmedCases() {
		return covidConfirmedCases;
	}

	public void setCovidConfirmedCases(int covidConfirmedCases) {
		this.covidConfirmedCases = covidConfirmedCases;
	}

	public int getCovidDeaths() {
		return covidDeaths;
	}

	public void setCovidDeats(int covidDeats) {
		this.covidDeaths = covidDeaths;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getActualMaxTemp() {
		return actualMaxTemp;
	}

	public void setActualMaxTemp(double actualMaxTemp) {
		this.actualMaxTemp = actualMaxTemp;
	}

	public double getActualMinTemp() {
		return actualMinTemp;
	}

	public void setActualMinTemp(double actualMinTemp) {
		this.actualMinTemp = actualMinTemp;
	}

	public double getActualMeanTemp() {
		return actualMeanTemp;
	}

	public void setActualMeanTemp(double actualMeanTemp) {
		this.actualMeanTemp = actualMeanTemp;
	}

	public double getAverageMaxTemp() {
		return averageMaxTemp;
	}

	public void setAverageMaxTemp(double averageMaxTemp) {
		this.averageMaxTemp = averageMaxTemp;
	}

	public double getAverageMinTemp() {
		return averageMinTemp;
	}

	public void setAverageMinTemp(double averageMinTemp) {
		this.averageMinTemp = averageMinTemp;
	}

	public double getRecordMaxTemp() {
		return recordMaxTemp;
	}

	public void setRecordMaxTemp(double recordMaxTemp) {
		this.recordMaxTemp = recordMaxTemp;
	}

	public double getRecordMinTemp() {
		return recordMinTemp;
	}

	public void setRecordMinTemp(double recordMinTemp) {
		this.recordMinTemp = recordMinTemp;
	}

	public double getRecordMaxTempYear() {
		return recordMaxTempYear;
	}

	public void setRecordMaxTempYear(double recordMaxTempYear) {
		this.recordMaxTempYear = recordMaxTempYear;
	}

	public double getRecordMinTempYear() {
		return recordMinTempYear;
	}

	public void setRecordMinTempYear(double recordMinTempYear) {
		this.recordMinTempYear = recordMinTempYear;
	}

	public double getActualPercipitation() {
		return actualPercipitation;
	}

	public void setActualPercipitation(double actualPercipitation) {
		this.actualPercipitation = actualPercipitation;
	}

	public double getAveragePrecipitation() {
		return averagePrecipitation;
	}

	public void setAveragePrecipitation(double averagePrecipitation) {
		this.averagePrecipitation = averagePrecipitation;
	}

	public double getRecordPrecipitation() {
		return recordPrecipitation;
	}

	public void setRecordPrecipitation(double recordPrecipitation) {
		this.recordPrecipitation = recordPrecipitation;
	}

}
