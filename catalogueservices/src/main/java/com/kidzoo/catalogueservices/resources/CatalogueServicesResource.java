package com.kidzoo.catalogueservices.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kidzoo.catalogueservices.service.CatalogueService;
import com.kidzoo.catalogueservices.servicebean.Toy;

import lombok.NonNull;

@RestController
public class CatalogueServicesResource {

	private static final Logger log = LoggerFactory.getLogger(CatalogueServicesResource.class);

	@Autowired
	private CatalogueService service;

	/*
	 * List of available and back order toys for consumers
	 * Input is not required, resource can be invoked directly.
	 */
	@GetMapping("/catalogue")

	public List<Toy> getToysList() {

		log.info("In get toylist services");
		return service.findAll();

	}

	/*
	 * Will return the toy from inventory based on the ID
	 * This method will accept ID as a parameter
	 */
	@GetMapping("/catalogue/{toyId}")
	public Toy getToysbyId(@PathVariable("toyId") long toyID) {

		log.info("In Get toys by ID call");
		return service.findById(toyID);

	}
	/*
	 * Will return the toy from inventory based on the ID
	 * this method needs to invoke by passing price range with (,)
	 *  comma seperated value  eg : 10,20
	 */

	@GetMapping("/catalogue/filter/{pricerange}")
	public List<Toy> getToysByPriceRange(@PathVariable("pricerange") @NonNull String priceRange) {

		return service.findByPriceRange(priceRange);

	}

}
