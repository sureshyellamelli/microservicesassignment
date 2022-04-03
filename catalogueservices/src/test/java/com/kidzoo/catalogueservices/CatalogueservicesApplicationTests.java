package com.kidzoo.catalogueservices;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kidzoo.catalogueservices.resources.CatalogueServicesResource;
import com.kidzoo.catalogueservices.servicebean.Toy;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Below are the Junit test cases for the Catalogue services
 * To execute the below test case make sure inventory services should be up and running
 *   
 * */

@SpringBootTest
class CatalogueservicesApplicationTests {
	
	@Autowired
	CatalogueServicesResource service;

	@Test
	void getToysListTest() {
		List<Toy> toys = service.getToysList();
		assertNotNull(toys);
		assertTrue( toys.size() > 0, "Data found");
		
	}
	
	@Test
	void getToysbyIdTest() {
		Toy toy = service.getToysbyId(1);
		assertNotNull(toy);
		assertTrue( toy.getName().equalsIgnoreCase("Barbie"), "Data found");
	}
	
	@Test
	void getToysByPriceRangeTest() {
		List<Toy> toys = service.getToysByPriceRange("1,20");
		assertNotNull(toys);
		assertTrue( toys.size() > 0, "Data found");
	}

}
