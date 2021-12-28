package com.bookingorder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Orders")
public class Booking {
	
	
	@Id
	private String id;
	private String noOfSeats;
	private String startStation;
	private String endStation;
	


	public Booking() {
	}

	public Booking(String id, String noOfSeats, String startStation, String endStation) {
		super();
		this.id = id;
		this.noOfSeats = noOfSeats;
		this.startStation = startStation;
		this.endStation = endStation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
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

	@Override
	public String toString() {
		return "Booking [id=" + id + ", noOfSeats=" + noOfSeats + ", startStation=" + startStation + ", endStation="
				+ endStation + "]";
	}
}
	