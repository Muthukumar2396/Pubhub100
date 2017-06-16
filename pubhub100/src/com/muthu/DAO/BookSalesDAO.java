package com.muthu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.muthu.util.ConnectionUtil;

public class BookSalesDAO {
	public int weekly(LocalDate date1,int weeks) throws SQLException {
		int sum = 0;
		Connection con = ConnectionUtil.getConnection();
		String sql = "select qty,order_date,sum(qty) from book_sales where (order_date BETWEEN ? and ? )";
		PreparedStatement pst = con.prepareStatement(sql);
		LocalDate date2 = date1.plusWeeks(weeks);
		return dateConvert(date1, sum, pst, date2);
	}

	public int monthly(LocalDate date1, int months) throws SQLException {
		int sum = 0;
		Connection con = ConnectionUtil.getConnection();
		String sql = "select qty,order_date,sum(qty) from book_sales where (order_date BETWEEN ? and ? )";
		PreparedStatement pst = con.prepareStatement(sql);
		LocalDate date2 = date1.plusMonths(months);
		return dateConvert(date1, sum, pst, date2);
	}

	public int yearly(LocalDate date1,int years) throws SQLException {
		int sum = 0;
		Connection con = ConnectionUtil.getConnection();
		String sql = "select qty,order_date,sum(qty) from book_sales where (order_date BETWEEN ? and ? )";
		PreparedStatement pst = con.prepareStatement(sql);
		LocalDate date2 = date1.plusYears(years);
		return dateConvert(date1, sum, pst, date2);
	}
	private int dateConvert(LocalDate date1, int sum, PreparedStatement pst, LocalDate date2) throws SQLException {
		String firstdate = date1.toString();
		String lastdate = date2.toString();
		pst.setObject(1, firstdate);
		pst.setObject(2, lastdate);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			 sum = rs.getInt(3);
		}
		return sum;
	}
	
}
