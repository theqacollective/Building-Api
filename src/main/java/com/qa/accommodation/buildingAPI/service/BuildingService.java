package com.qa.accommodation.buildingAPI.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.accommodation.buildingAPI.Constants;
import com.qa.accommodation.buildingAPI.entities.Building;
import com.qa.accommodation.buildingAPI.repository.BuildingRepo;

@Service
public class BuildingService {
	
	private BuildingRepo buildingRepo;
	
	public BuildingService(BuildingRepo buildingRepo) {
		this.buildingRepo = buildingRepo;
	}
	
	public List<Building> getAllBuildings() {
		return this.buildingRepo.findAll();
	}
	
	public List<Building> buildingSearch(Building building) {
		return this.getAllBuildings().stream().filter(x -> x.matches(building)).collect(Collectors.toList());
	}
	
	public String createBuilding(Building building) {
		this.buildingRepo.save(building);
		return Constants.getCreateSuccess();
	}
	
	public String deleteBuilding(Building building) {
		this.buildingRepo.delete(building);
		return Constants.getDeleteSuccess();
	}
}
