/**
 * 
 */
package com.kidzoo.inventory.resources;

import java.util.List;
import java.util.ArrayList;

import com.kidzoo.inventory.repository.ToysRepository;
import com.kidzoo.inventory.service.ToysService;
import com.kidzoo.inventory.servicebeans.Toy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidzoo.inventory.InventoryApplication;
import com.kidzoo.inventory.entityjpa.Toys;

/**
 * 
 * Main Resource End point class for inventory API, this class exposes multiple
 * end point to interact with inventory to check the stock status
 * 
 * 
 */

@RestController
public class InventoryResource {
	private static final Logger log = LoggerFactory.getLogger(InventoryResource.class);
	@Autowired
	private ToysService toysService;

	public List<Toy> toysList = new ArrayList<Toy>();

	/*
	 * List of available and back order toys for consumers
	 * 
	 */
	@GetMapping("/inventory")
	public List<Toys> getToysList() {

		return toysService.findAll();
	}
	
	/*
	 * Will return the toy from inventory based on the ID
	 * This method will accept ID as a parameter
	 */

	@GetMapping("/inventory/{toyId}")
	public Toys getToysbyId(@PathVariable("toyId") int toyID) {

		log.info("In Get toys by ID call");
		return toysService.findById(toyID);

	} 
	
	/*
	 * Will return the toy from inventory based on the ID
	 * this method needs to invoke by passing price range with (,)
	 *  comma seperated value  eg : 10,20
	 */

	@GetMapping("/inventory/filter/{pricerange}")
	public List<Toys> getToysByPriceRange(@PathVariable("pricerange") String priceRange) {

		String[] values = priceRange.split(",");

		return toysService.findByPriceRange(Double.valueOf(values[0]), Double.valueOf(values[1]));
	}

}
