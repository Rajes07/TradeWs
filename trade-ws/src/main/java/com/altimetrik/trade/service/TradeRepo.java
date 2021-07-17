package com.altimetrik.trade.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.altimetrik.trade.model.TradeDetails;
import com.altimetrik.trade.model.TradeRequest;

@Repository
public class TradeRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertTradeDetails(List<TradeDetails> tradeList) {

		int[] insert = jdbcTemplate.batchUpdate(
				"INSERT INTO TRADE(SELLER,BUYER,STOCK,PRICE,TRADE_DATE) VALUES(?,?,?,?,CURRENT_DATE)",
				new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						TradeDetails d = tradeList.get(i);
						ps.setString(1, d.getSeller());
						ps.setString(2, d.getBuyer());
						ps.setString(3, d.getStock());
						ps.setLong(4, d.getPrice());
					}

					@Override
					public int getBatchSize() {
						return tradeList.size();
					}
				});
		return Arrays.stream(insert).sum();
	}

	public int insertMismatchOrder(List<TradeRequest> unMatchList) {
		int[] insert = jdbcTemplate.batchUpdate("INSERT INTO ORDERS(PARTY,CATEGORY,STOCK,PRICE) VALUES(?,?,?,?)",
				new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						TradeRequest d = unMatchList.get(i);
						ps.setString(1, d.getParty());
						ps.setString(2, d.getCatgory());
						ps.setString(3, d.getStock());
						ps.setLong(4, d.getPrice());
					}

					@Override
					public int getBatchSize() {
						return unMatchList.size();
					}
				});
		return Arrays.stream(insert).sum();

	}

	public List<TradeDetails> getTradeDetails() {
		List<TradeDetails> details = jdbcTemplate.query("SELECT SELLER,BUYER,STOCK,PRICE,TRADE_DATE FROM TRADE",
				(rs, rowNum) -> {
					TradeDetails d = new TradeDetails();
					d.setBuyer(rs.getString("SELLER"));
					d.setSeller(rs.getString("BUYER"));
					d.setStock(rs.getString("STOCK"));
					d.setPrice(rs.getLong("PRICE"));
					d.setTradeDate(rs.getString("TRADE_DATE"));
					return d;
				});
		return details;
	}

	public List<TradeRequest> getUnmatchedOrders() {
		List<TradeRequest> details = jdbcTemplate.query("SELECT PARTY,CATEGORY,STOCK,PRICE FROM ORDERS",
				(rs, rowNum) -> {
					TradeRequest d = new TradeRequest();
					d.setParty(rs.getString("PARTY"));
					d.setCatgory(rs.getString("CATEGORY"));
					d.setStock(rs.getString("STOCK"));
					d.setPrice(rs.getLong("PRICE"));
					return d;
				});
		return details;
	}
}
