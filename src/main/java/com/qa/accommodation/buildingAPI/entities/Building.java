package com.qa.accommodation.buildingAPI.entities;

import org.springframework.data.annotation.Id;

public class Building {
	
	@Id
	private String id;
	
	private String buildingName;
	private String buildingLocation;
	private String ownerName;
	private String ownerNumber;
	private String ownerEmail;
	
	public Building() {
		
	}

	public Building(String buildingName, String buildingLocation, String ownerName, String ownerNumber,
			String ownerEmail) {
		super();
		this.buildingName = buildingName;
		this.buildingLocation = buildingLocation;
		this.ownerName = ownerName;
		this.ownerNumber = ownerNumber;
		this.ownerEmail = ownerEmail;
	}
	
	public String getId() {
		return id;
	}
	
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
	public String getBuildingLocation() {
		return buildingLocation;
	}

	public void setBuildingLocation(String buildingLocation) {
		this.buildingLocation = buildingLocation;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerNumber() {
		return ownerNumber;
	}

	public void setOwnerNumber(String ownerNumber) {
		this.ownerNumber = ownerNumber;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	
	public boolean matches(Building building) {
		Boolean buildingCheck = this.getBuildingName().contentEquals(building.getBuildingName()) ;
		Boolean buildingNull = building.getBuildingName().contentEquals("N/A");
		Boolean locationCheck = this.getBuildingLocation().contentEquals(building.getBuildingLocation());
		Boolean locationNull = building.getBuildingLocation().contentEquals("N/A");
		Boolean ownerCheck = this.getOwnerName().contentEquals(building.getOwnerName());
	    Boolean ownerNull = building.getOwnerName().contentEquals("N/A");
		
		buildingCheck = buildingCheck||buildingNull;
		locationCheck = locationCheck||locationNull;
		ownerCheck = ownerCheck||ownerNull;
		return (buildingCheck && locationCheck && ownerCheck);
	}
	
}
