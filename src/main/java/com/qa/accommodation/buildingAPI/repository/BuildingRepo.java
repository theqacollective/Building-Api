package com.qa.accommodation.buildingAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.accommodation.buildingAPI.entities.Building;

@Repository
public interface BuildingRepo extends JpaRepository<Building, Long>{

}
