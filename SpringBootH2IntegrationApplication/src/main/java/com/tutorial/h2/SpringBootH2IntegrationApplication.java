package com.tutorial.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


//@EnableCircuitBreaker
//@RefreshScope
@SpringBootApplication
//@EnableSwagger2
@EnableHystrix
public class SpringBootH2IntegrationApplication {
	
	/*
	 * @Bean public Docket swagger() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any()) .build(); }
	 */
	private static final Logger logger = LoggerFactory.getLogger(SpringBootH2IntegrationApplication.class);

	public static void main(String[] args) {
		logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
		SpringApplication.run(SpringBootH2IntegrationApplication.class, args);
	}

}
