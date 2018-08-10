package com.prateek.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.prateek.microservices.currencyconversionservice.CurrencyConversionBean;


/*
 *	We will use this interface to call  currency-exchange-service from currency-conversion-service using
 *	REST client Feign.
 */
//@FeignClient(name ="currency-exchange-service", url="localhost:8000" )
//@FeignClient(name ="currency-exchange-service")		//uncommnet if you want to use your app without Zuul API gateway
@FeignClient(name = "netflix-zuul-api-gateway-server")  //route API calls through Zuul API gateway 
/*
 * RibbonClient: A client side load balancer which will invoke one of the multiple instances of currency-exchange-service
 * based on load.
 */
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}") //uncommnet if you want to use your app without Zuul API gateway
	@GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}") 
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
	
	
	
}
