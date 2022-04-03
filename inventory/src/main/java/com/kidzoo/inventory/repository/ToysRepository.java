package com.kidzoo.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kidzoo.inventory.servicebeans.Toy;

import java.util.List;

import com.kidzoo.inventory.entityjpa.Toys;

public interface ToysRepository extends JpaRepository<Toys, Long> {

	List<Toys> findByName(String name);

	Toys findById(long id);
	
	List<Toys> findByStatusIn(List<String> names);
	
	@Query(value = "select t.* from Toys t where t.price >= ?1 AND t.price <= ?2 ", nativeQuery = true)
	List<Toys> findByPrice(double startprice, double endprice);

}
