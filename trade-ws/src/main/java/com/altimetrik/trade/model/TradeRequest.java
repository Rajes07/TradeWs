package com.altimetrik.trade.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TradeRequest {
	private String party;
	private String catgory;
	private String stock;
	private Long price;
	private String tradeDate;


}
