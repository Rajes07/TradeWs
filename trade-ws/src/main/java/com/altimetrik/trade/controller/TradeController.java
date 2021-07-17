package com.altimetrik.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.trade.model.TradeDetails;
import com.altimetrik.trade.model.TradeRequest;
import com.altimetrik.trade.service.TradeService;

@RestController
public class TradeController {
	@Autowired
	TradeService tradeService;

	@PostMapping(value = "/createTrade")
	public String createTrade(@RequestBody List<TradeRequest> request) {
		int count=tradeService.createTrade(request);
		return count+" Trade matched details are created";
	}
	
	@GetMapping(value="/getTradeDetails")
	public List<TradeDetails> getTradeDetails(@RequestBody TradeRequest req,@RequestParam String key) {
		
		return tradeService.getTradeDetails(req,key);
		
	}
	
	@GetMapping(value="/getUnmatchedOrders")
	public List<TradeRequest>getUnmatchedOrders(@RequestBody TradeRequest req,@RequestParam String key) {
		return tradeService.getUnmatchedOrders(req,key);
		
	}
}
