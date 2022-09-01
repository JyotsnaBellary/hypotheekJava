package com.wipro.velocity.hypotheek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/*
 * Swagger is a specification for documenting REST API.
It specifies the format (URL, method, and representation)
to describe REST web services.
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
	   //creating bean
    @Bean
    public Docket api()
    {
    //creating constructor of Docket class that accepts parameter DocumentationType
    return new Docket(DocumentationType.SWAGGER_2);
	
}
}