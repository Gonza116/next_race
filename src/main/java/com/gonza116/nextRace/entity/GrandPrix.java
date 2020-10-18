package com.gonza116.nextRace.entity;

public class GrandPrix {

	public String gp_name;
	public String date;
	public String circuit;
	public String country;
	
	public GrandPrix(String name, String date, String circuit, String country) {
		super();
		this.gp_name = name;
		this.date = date;
		this.circuit = circuit;
		this.country = country;
	}

	public String getName() {
		return gp_name;
	}

	public void setName(String name) {
		this.gp_name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCircuit() {
		return circuit;
	}

	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
