package com.muthu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.muthu.util.ConnectionUtil;

public class InventoryDAO {
	public void increaseQuantity(Integer id, Integer qty) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update book_inventory set qty= qty+? where book_id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, qty);
		pst.setLong(2, id);
		int rows = pst.executeUpdate();
		System.out.println("Updated : " + rows);

	}
}
