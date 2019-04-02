package com.qa.accommodation.buildingAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.accommodation.buildingAPI.Constants;
import com.qa.accommodation.buildingAPI.entities.Building;
import com.qa.accommodation.buildingAPI.entities.BuildingBuilder;
import com.qa.accommodation.buildingAPI.service.BuildingService;

@RestController
@CrossOrigin
public class BuildingController {
	private BuildingService buildingService;
	
	public BuildingController(BuildingService buildingService) {
		this.buildingService = buildingService;
	}
	
	@PostMapping("/createBuilding")
	public String createBuilding(@RequestBody Building building) {
		return this.buildingService.createBuilding(building);
	}
	
	@GetMapping("/getAllBuildings")
	public List<Building> getAllBuildings() {
		return this.buildingService.getAllBuildings();
	}
	
	@GetMapping("/buildingSearch")
	public List<Building> buildingSearch(String buildingName, String buildingLocation, String ownerName){
		return this.buildingService.buildingSearch(BuildingBuilder.getBuildingBuilder().buildingName(buildingName)
				.buildingLocation(buildingLocation).ownerName(ownerName).buildingBuild());
	}
	
	@DeleteMapping("/deleteBuilding")
	public String deleteBuilding(String buildingName, String buildingLocation, String ownerName) {
		List<Building> buildings = this.buildingSearch(buildingName, buildingLocation, ownerName);
		for(int i = 0; i < buildings.size(); i++) {
			this.buildingService.deleteBuilding(buildings.get(i));
		}
		return Constants.getDeleteSuccess();
	}
}
