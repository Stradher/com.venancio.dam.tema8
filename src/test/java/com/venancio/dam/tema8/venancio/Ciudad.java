package com.venancio.dam.tema8.venancio;

public class Ciudad {
	private int id;
	private String name;
	private String countryCode;
	private String District;
	private int population;
	
	public Ciudad(int id, String name, String countryCode, String district, int population) {		
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		String District = district;
		this.population = population;
	}

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}



	@Override
	public String toString() {
		return "\nCiudad [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", District=" + District
				+ ", population=" + population + "]";
	}
	
	
	
	
	
	
}
