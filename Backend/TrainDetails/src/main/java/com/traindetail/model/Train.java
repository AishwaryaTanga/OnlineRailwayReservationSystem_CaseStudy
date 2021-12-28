package com.traindetail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Train")
public class Train {
	

	@Id
	private String trainid;
	private String trainName;
	private String startStation;
	private String endStation;
	private String timings;
	
	


public Train() {
	
}


public Train(String trainid, String trainName, String startStation, String endStation,String timings ) {
	super();
	this.trainid = trainid;
	this.trainName = trainName;
	this.startStation = startStation;
	this.endStation = endStation;
	this.timings = timings;
	
}



public String getTrainid() {
	return trainid;
}


public void setTrainid(String trainid2) {
	this.trainid = trainid2;
}


public String getTrainName() {
	return trainName;
}


public void setTrainName(String trainName) {
	this.trainName = trainName;
}


public String getStartStation() {
	return startStation;
}


public void setStartStation(String startStation) {
	this.startStation = startStation;
}


public String getEndStation() {
	return endStation;
}


public void setEndStation(String endStation) {
	this.endStation = endStation;
}
public String getTimings() {
	return timings;
}


public void setTimings(String timings) {
	this.timings = timings;
}

}
