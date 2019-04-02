package com.qa.accommodation.buildingAPI.entities;

import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class BuildingBuilder {
	private static BuildingBuilder buildingBuilder;
	
	private String buildingName;
	private String buildingLocation;
	private String ownerName;
	private String ownerNumber;
	private String ownerEmail;
	
	private BuildingBuilder() {
		
	}
	
	public static BuildingBuilder getBuildingBuilder() {
		if(buildingBuilder == null) {
			buildingBuilder = new BuildingBuilder();
		}
		return buildingBuilder;
	}

	public BuildingBuilder buildingName(String buildingName) {
		this.buildingName = buildingName;
		return this;
	}
	
	public BuildingBuilder buildingLocation(String buildingLocation) {
		this.buildingLocation = buildingLocation;
		return this;
	}
	
	public BuildingBuilder ownerName(String ownerName) {
		this.ownerName = ownerName;
		return this;
	}
	
	public BuildingBuilder ownerNumber(String ownerNumber) {
		this.ownerNumber = ownerNumber;
		return this;
	}
	
	public BuildingBuilder ownerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
		return this;
	}
	
	public Building buildingBuild() {
		Building building = new Building(
				Optional.ofNullable(this.buildingName).orElse("N/A"),
				Optional.ofNullable(this.buildingLocation).orElse("N/A"),
				Optional.ofNullable(this.ownerName).orElse("N/A"),
				Optional.ofNullable(this.ownerNumber).orElse("N/A"),
				Optional.ofNullable(this.ownerEmail).orElse("N/A")
				);
		buildingBuilder = new BuildingBuilder();
		return building;
	}
}
