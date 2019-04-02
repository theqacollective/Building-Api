package com.qa.accommodation.buildingAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.qa.accommodation.buildingAPI.entities.Building;

@Repository
public interface BuildingRepo extends MongoRepository<Building, Long>{

}
