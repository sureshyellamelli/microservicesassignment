package com.kidzoo.catalogueservices.config;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class WebConfig {

	/**
	 * Below is the configurations of swagger documentation
	 * 
	 */
	@Bean
	public Docket config() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.kidzoo.catalogueservices")).build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Swagger Kidzoo Catalogue Services", 
	      "This is Kidzoo Catalogue Services", 
	      "1.0.0", 
	      "Terms of service", 
	      new Contact("kidzoo", "catalogue.kidzoo.com", "catalogueteam@kidzoo.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

}
