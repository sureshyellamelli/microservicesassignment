package com.kidzoo.catalogueservices.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.kidzoo.catalogueservices.servicebean.Toy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@Service
public class CatalogueService {

	@Autowired
	private RestTemplate template;
	private static final Logger log = LoggerFactory.getLogger(CatalogueService.class);
	final String baseUrl = "http://INVENTORY-SERVICE/";

	public List<Toy> findAll() {

		log.info("In template" + baseUrl);
		ArrayList<Toy> list = template.getForObject(baseUrl + "inventory", ArrayList.class);
		log.info("Toy :  " + list.size());
		return list;

	}

	public Toy findById(long toyId) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity request = new HttpEntity(headers);

		builder.path("inventory/{toyId}");
		log.info("URL Final : " + builder.buildAndExpand(toyId).toUriString());
		ResponseEntity<Toy> response = template.exchange(builder.buildAndExpand(toyId).toUriString(), HttpMethod.GET,
				request, Toy.class);

		log.info(response.getBody().toString());

		return response.getBody();
	}

	public List<Toy> findByPriceRange(String priceRange) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity request = new HttpEntity(headers);

		builder.path("inventory/filter/{pricerange}");
		log.info("URL Final : " + builder.buildAndExpand(priceRange).toUriString());
		
		ResponseEntity<List> response = template.exchange(builder.buildAndExpand(priceRange).toUriString(),
				HttpMethod.GET, request, List.class);

		return response.getBody();
	}

}
