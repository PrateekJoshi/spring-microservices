package com.prateek.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;	//will be used to fetch values from property file
	
	@Autowired
	private ExchangeValueRepository repository;
	
	/*
	 * Get exchange rate from currency {from} to currency {to}
	 */
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		/* Fetch values of exchange rate from database using JPA */
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		/* Since we will run multiple instances of this service, fetch the running port of the instance dynamically */
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
