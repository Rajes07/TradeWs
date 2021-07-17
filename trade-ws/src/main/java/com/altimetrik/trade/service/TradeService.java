package com.altimetrik.trade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.trade.model.TradeDetails;
import com.altimetrik.trade.model.TradeRequest;

@Service
public class TradeService {

	@Autowired
	TradeRepo repo;

	public int createTrade(List<TradeRequest> list) {
		List<TradeDetails> tradeList = new ArrayList<>();
		List<TradeRequest> unMatchList = new ArrayList<TradeRequest>();
		list.stream().forEach(req -> {
			List<TradeRequest> tradeReq = list.stream().filter(r -> req.getStock().equals(r.getStock())
					&& req.getPrice().equals(r.getPrice()) && !req.getCatgory().equals(r.getCatgory()))
					.collect(Collectors.toList());

			if (tradeReq.stream().findFirst().isPresent()) {
				if (req.getCatgory().equals("SELL")) {
					TradeDetails detail = TradeDetails.builder().seller(req.getParty())
							.buyer(tradeReq.stream().findFirst().get().getParty()).stock(req.getStock())
							.price(req.getPrice()).build();
					tradeList.add(detail);
				}
				unMatchList.addAll(tradeReq.stream().filter(
						filterReq -> !tradeReq.stream().findFirst().get().getParty().equals(filterReq.getParty()))
						.collect(Collectors.toList()));
			} else {
				unMatchList.add(req);
			}
		});
		tradeList.stream().forEach(trade -> System.out.println(trade.toString()));
		unMatchList.stream().forEach(trade -> System.out.println(trade.toString()));
		repo.insertMismatchOrder(unMatchList);
		return repo.insertTradeDetails(tradeList);

	}

	public List<TradeDetails> getTradeDetails(TradeRequest req, String key) {
		Predicate<TradeDetails> filter = null;
		if (key.equals("party"))
			filter = detail -> detail.getBuyer().equals(req.getParty());
		else if (key.equals("symbol"))
			filter = detail -> detail.getStock().equals(req.getStock());
		else if (key.equals("date"))
			filter = detail -> detail.getTradeDate().equals(req.getTradeDate());

		List<TradeDetails> details = repo.getTradeDetails();
		if (null != filter)
			return details.stream().filter(filter).collect(Collectors.toList());
		else
			return details;
	}

	public List<TradeRequest> getUnmatchedOrders(TradeRequest req, String key) {
		Predicate<TradeRequest> filter = null;
		if (key.equals("symbol"))
			filter = detail -> detail.getStock().equals(req.getStock());
		else if (key.equals("price"))
			filter = detail -> detail.getPrice().equals(req.getPrice());
		List<TradeRequest> details = repo.getUnmatchedOrders();
		if (null != filter)
			return details.stream().filter(filter).collect(Collectors.toList());
		else
			return details;
	}

}
