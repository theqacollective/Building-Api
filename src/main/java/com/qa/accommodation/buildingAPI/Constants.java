package com.qa.accommodation.buildingAPI;

import java.nio.charset.Charset;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.accommodation.buildingAPI.entities.Building;
import com.qa.accommodation.buildingAPI.entities.BuildingBuilder;

public class Constants {
	public static final String CREATE_URL = "/createBuilding";
	public static final String DELETE_URL = "/deleteBuilding";
	public static final String UPDATE_URL = "/updateBuilding/{buildingName}";
	public static final String GET_ALL_URL = "/getAllBuildings";
	public static final String SEARCH_URL = "/buildingSearch";
	
	
	private static final String DELETE_SUCCESS = "Successfully Deleted";
	private static final String CREATE_SUCCESS = "Building has been successfully created";
	
	private final static Building NULL_BUILDING = new Building();
	private final static Building BUILDING_BUILDER = BuildingBuilder.getBuildingBuilder().buildingBuild();
	
	private final static String TEST_BUILDING_NAME = "Test Building";
	private final static String TEST_BUILDING_LOCATION = "20 Test Avenue, Test Street";
	private final static String TEST_OWNER_NAME = "Test Owner";
	private final static String TEST_OWNER_NUMBER = "07778889991";
	private final static String TEST_OWNER_EMAIL = "TestOwner@Tester.com";
	private final static String NA_STRING = "N/A";
	private static final String UPDATE_MESSSAGE = "Entry updated";
	private final static Building CONSTRUCTED_BUILDING = new Building(TEST_BUILDING_NAME, TEST_BUILDING_LOCATION,
			TEST_OWNER_NAME, TEST_OWNER_NUMBER, TEST_OWNER_EMAIL);
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final ResponseEntity<Building> BUILDING_CREATED = new ResponseEntity<Building>(HttpStatus.OK);
	public static final MediaType APPLICTION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	public static String getDeleteSuccess() {
		return DELETE_SUCCESS;
	}
	public static String getCreateSuccess() {
		return CREATE_SUCCESS;
	}
	
	public static Building getNullBuilding() {
		return NULL_BUILDING;
	}
	public static Building getBuildingBuilder() {
		return BUILDING_BUILDER;
	}
	public static Building getConstructedBuilding() {
		return CONSTRUCTED_BUILDING;
	}
	public static String getBuildingCreated() {
		return "building created";
	}
	public static String getNaString() {
		return NA_STRING;
	}
	public static String getUpdateMesssage() {
		return UPDATE_MESSSAGE;
	}
	
	
}
