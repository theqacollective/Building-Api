package com.qa.accommodation.buildingAPI.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping(Constants.CREATE_URL)
	public String createBuilding(@RequestBody Building building) {
		return this.buildingService.createBuilding(building);
	}
	
	@GetMapping(Constants.GET_ALL_URL)
	public List<Building> getAllBuildings() {
		return this.buildingService.getAllBuildings();
	}
	
	@GetMapping(Constants.SEARCH_URL)
	public List<Building> buildingSearch(String buildingName){
		return this.buildingService.buildingSearch(BuildingBuilder.getBuildingBuilder().buildingName(buildingName).buildingBuild());
	}
	public List<Building> buildingDeleteSearch(String buildingName, String buildingLocaiton, String ownerName){
		return this.buildingService.buildingSearch(BuildingBuilder.getBuildingBuilder().buildingName(buildingName).buildingLocation(buildingLocaiton).ownerName(ownerName).buildingBuild());
	}
	
	@DeleteMapping("/deleteBuilding")
	public String deleteBuilding(@RequestBody Building building) {
		List<Building> buildings = this.buildingDeleteSearch(building.getBuildingName(), building.getBuildingLocation(), building.getOwnerName());
		for(int i = 0; i < buildings.size(); i++) {
			this.buildingService.deleteBuilding(buildings.get(i));
		}
		return Constants.getDeleteSuccess();
	}
	@PutMapping(Constants.UPDATE_URL)
	public String updateBuilding(@PathVariable("buildingName")String buildingName, @RequestBody Building updateBuilding)
	{
		return this.buildingService.updateBuilding(buildingName, updateBuilding);
		
	}
}
