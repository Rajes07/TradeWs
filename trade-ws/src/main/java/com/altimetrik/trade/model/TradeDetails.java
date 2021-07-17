package com.altimetrik.trade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeDetails {
	
	String seller;
	String buyer;
	String stock;
	Long price;
	String tradeDate;
	

}
