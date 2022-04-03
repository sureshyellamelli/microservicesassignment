package com.kidzoo.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidzoo.inventory.entityjpa.Toys;
import com.kidzoo.inventory.repository.ToysRepository;
import com.kidzoo.inventory.servicebeans.Toy;

@Service
public class ToysService {

	@Autowired
	private ToysRepository toysRespository;

	public Toys findById(long id) {
		return toysRespository.findById(id);
	}

	public List<Toys> findAll() {
		return toysRespository
				.findByStatusIn(List.of(Messages.getString("ToysService.AVAILABLE"),
						Messages.getString("ToysService.BACKORDER"))); 
	}

	public List<Toys> findByPriceRange(double startPrice, double endPrice){
	
		return toysRespository
				.findByPrice(startPrice, endPrice); 
	}

}
