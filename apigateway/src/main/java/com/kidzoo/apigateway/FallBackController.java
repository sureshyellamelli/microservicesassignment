package com.kidzoo.apigateway;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	 @RequestMapping("/inventoryFallBack")
	    public Mono<String> inventoryServiceFallBack() {
	        return Mono.just("Inventory Service is taking too long to respond or is down. Please try again later");
	    }
	    @RequestMapping("/catalogueFallback")
	    public Mono<String> catalogueServiceFallBack() {
	        return Mono.just("Catalogue Service is taking too long to respond or is down. Please try again later");
	    }

}
