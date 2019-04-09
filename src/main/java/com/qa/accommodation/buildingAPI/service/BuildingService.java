package com.qa.accommodation.buildingAPI.service;

import java.util.List;
import java.util.Optional;
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
	

	public List<Building> buildingDeleteSearch(Building building) {
		return this.getAllBuildings().stream().filter(x -> x.matches(building)).collect(Collectors.toList());
	}

	public String createBuilding(Building building) {
		if(this.buildingRepo.getBuildingByBuildingName(building.getBuildingName()) != null)
		{
			return "Building Already Exists";
		}
		this.buildingRepo.save(building);
		return Constants.getCreateSuccess();
	}

	public String deleteBuilding(Building building) {
		if(this.buildingRepo.getBuildingByBuildingName(building.getBuildingName()) == null)
		{
			return "Building Does Not Exist";
		}
		this.buildingRepo.delete(building);
		return Constants.getDeleteSuccess();
	}

	public String updateBuilding(String buildingName, Building updateBuilding) {
		Building buildingToUpdate = this.buildingSearch(buildingRepo.getBuildingByBuildingName(buildingName)).get(0);
		buildingToUpdate.setBuildingLocation(Optional.ofNullable(updateBuilding.getBuildingLocation())
				.orElse(Optional.ofNullable(buildingToUpdate.getBuildingLocation()).orElse(Constants.getNaString())));
		buildingToUpdate.setBuildingName(Optional.ofNullable(updateBuilding.getBuildingName())
				.orElse(Optional.ofNullable(buildingToUpdate.getBuildingName()).orElse(Constants.getNaString())));
		buildingToUpdate.setOwnerEmail(Optional.ofNullable(updateBuilding.getOwnerEmail())
				.orElse(Optional.ofNullable(buildingToUpdate.getOwnerEmail()).orElse(Constants.getNaString())));
		buildingToUpdate.setOwnerName(Optional.ofNullable(updateBuilding.getOwnerName())
				.orElse(Optional.ofNullable(buildingToUpdate.getOwnerName()).orElse(Constants.getNaString())));
		buildingToUpdate.setOwnerNumber(Optional.ofNullable(updateBuilding.getOwnerNumber())
				.orElse(Optional.ofNullable(buildingToUpdate.getOwnerNumber()).orElse(Constants.getNaString())));
		this.buildingRepo.delete(buildingSearch(buildingRepo.getBuildingByBuildingName(buildingName)).get(0));
		this.buildingRepo.save(buildingToUpdate);
		return Constants.getUpdateMesssage();
	}
}
