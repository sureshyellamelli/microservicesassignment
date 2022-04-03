package com.kidzoo.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.kidzoo.inventory.entityjpa.Toys;
import com.kidzoo.inventory.repository.ToysRepository;
import com.kidzoo.inventory.service.Messages;
import com.kidzoo.inventory.servicebeans.Toy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableEurekaClient
public class InventoryApplication {
	private static final Logger log = LoggerFactory.getLogger(InventoryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);		
	}
	
	/*
	 * Below code will initialize the in memory DB with toys data in order to test the API.  
	 * 
	 */

	@Bean
	public CommandLineRunner demo(ToysRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Toys(Long.parseLong("1"), Float.parseFloat("20.20"), Long.parseLong("3"), "Barbie",
					"/img/product.jpg", "available"));
			repository.save(new Toys(Long.parseLong("2"), Float.parseFloat("16.40"), Long.parseLong("1"), "teddy bear",
					"/img/product.jpg", "unavailable"));
			repository.save(new Toys(Long.parseLong("3"), Float.parseFloat("19.60"), Long.parseLong("4"), "airplane",
					"/img/product.jpg", "backorder"));
			repository.save(new Toys(Long.parseLong("4"), Float.parseFloat("10.30"), Long.parseLong("2"), "train",
					"/img/product.jpg", "available"));
			repository.save(new Toys(Long.parseLong("5"), Float.parseFloat("11.90"), Long.parseLong("5"), "bicycle",
					"/img/product.jpg", "unavailable"));
			
			List<Toys> toys = repository.findByStatusIn(List.of(Messages.getString("ToysService.AVAILABLE"),
						Messages.getString("ToysService.BACKORDER")));
		      log.info("Toys found with findById(1L):");
		      log.info("--------------------------------");
		      log.info(toys.toString());
		      log.info("");

		};
		
		
	}

}
