package com.kidzoo.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kidzoo.inventory.entityjpa.Toys;
import com.kidzoo.inventory.service.ToysService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@SpringBootTest
class InventoryApplicationTests {
	
	@Autowired
	private ToysService service;

	
	
	@Test
	void findAllTest() {
		List<Toys> toys = service.findAll();
		assertNotNull(toys);
		assertTrue( toys.size() > 0, "Data found");
		
	}
	
	@Test
	void findByIdTest() {
		Toys toy = service.findById(1);
		assertNotNull(toy);
		assertTrue( toy.getName().equalsIgnoreCase("Barbie"), "Data found");
	}
	
	@Test
	void findByPriceRangeTest() {
		List<Toys> toys = service.findByPriceRange(1l,20l);
		assertNotNull(toys);
		assertTrue( toys.size() > 0, "Data found");
	}

}
