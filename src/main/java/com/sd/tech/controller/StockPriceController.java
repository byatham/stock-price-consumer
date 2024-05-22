package com.sd.tech.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/stock")
public class StockPriceController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getPrice")
	public ResponseEntity<Map<String, Double>> getCompanyStockPrice(@RequestParam String company) {

		String endPointUrl = "http://localhost:9020/stock/price?name=" +company;
		try {
			System.out.println(" request inside getCompanyStockPrice() ");
			ResponseEntity<Map<String, Double>> exchangeResponse = restTemplate.exchange(endPointUrl, HttpMethod.GET,
					null, new ParameterizedTypeReference<Map<String, Double>>() {
					});
			System.out.println("inside getCompanyStockPrice() StockPriceController()  " + exchangeResponse.getBody());

			return ResponseEntity.status(HttpStatus.CREATED).body(exchangeResponse.getBody());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HashMap<String, Double>());
		}
	}

}
