package com.qa.accommodation.buildingAPI.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.accommodation.buildingAPI.repository.BuildingRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
	@Autowired
	private BuildingRepo buildingRepo;
	
	@Test
	public void initialisationTest() {
		assertThat(buildingRepo).isNotNull();
	}
	@Test
	public void noDataTest() {
		assertThat(buildingRepo.count()).isEqualTo(0);
	}

}
