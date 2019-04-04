package com.qa.accommodation.buildingAPI.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.qa.accommodation.buildingAPI.Constants;
import com.qa.accommodation.buildingAPI.controllers.BuildingController;
import com.qa.accommodation.buildingAPI.entities.Building;
import com.qa.accommodation.buildingAPI.entities.BuildingBuilder;
import com.qa.accommodation.buildingAPI.service.BuildingService;

@RunWith(SpringRunner.class)
@WebMvcTest(BuildingController.class)
@AutoConfigureWebMvc
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BuildingService service;
	@MockBean
	private BuildingBuilder builder;
	@MockBean
	RestTemplateBuilder rtb;

	private Building testBuilding;

	@Before
	public void setup() {
		this.testBuilding = Constants.getConstructedBuilding();
	}

	@Test
	public void testBuildingCreation() throws Exception {
		Constants.OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = Constants.OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		String postContent = ow.writeValueAsString(testBuilding);
		Mockito.when(service.createBuilding(testBuilding)).thenReturn("Building created");
		MvcResult result = mockMvc
				.perform(post("/createBuilding").contentType(Constants.APPLICTION_JSON_UTF8).content(postContent))
				.andReturn();
		assertThat(result.getResponse().getContentAsString().getClass().equals(ResponseEntity.class));
	}

	@Test
	public void testGetAll() throws Exception {
		List<Building> MOCKED_BUILDINGS = new ArrayList<Building>();
		MOCKED_BUILDINGS.add(Constants.getConstructedBuilding());
		when(service.getAllBuildings()).thenReturn(MOCKED_BUILDINGS);
		assertThat(mockMvc.perform(get("/getAllBuildings").accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("Test Building"))));
	}
	
	@Test
	public void testSearch() throws Exception {
		List<Building> MOCKED_BUILDINGS = new ArrayList<Building>();
		MOCKED_BUILDINGS.add(testBuilding);
		MOCKED_BUILDINGS.add(Constants.getBuildingBuilder());
		
		Mockito.when(service.buildingSearch(testBuilding)).thenReturn(MOCKED_BUILDINGS.stream().filter(x -> x.matches(testBuilding)).collect(Collectors.toList()));
		Constants.OBJECT_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = Constants.OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
		String postContent = ow.writeValueAsString(testBuilding);
		TypeReference<List<Building>> mapType = new TypeReference<List<Building>>( ) {}; 
	}

}