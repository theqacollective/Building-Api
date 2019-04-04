package com.qa.accommodation.buildingAPI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.accommodation.buildingAPI.controllerTest.ControllerTest;
import com.qa.accommodation.buildingAPI.repositoryTest.RepositoryTest;


@RunWith(Suite.class)

@SuiteClasses({ ControllerTest.class, RepositoryTest.class, BuildingApiApplicationTests.class,  SmokeTest.class })

@SpringBootTest
public class TestSuite {

}

