package com.muthu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muthu.model.Book;
import com.muthu.model.BookInventory;
import com.muthu.model.BookSales;
import com.muthu.util.ConnectionUtil;

public class BookOrderDAO {
	public List<BookInventory> ViewAll() throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status,qty,book_id from book,book_inventory where id=book_id ";
		PreparedStatement pst = con.prepareStatement(sql);

		List<BookInventory> list = new ArrayList<BookInventory>();
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Book b = new Book();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPublishDate(rs.getString("publishdate"));
			b.setContent(rs.getString("content"));
			b.setPrice(rs.getDouble("price"));
			b.setStatus(rs.getString("Status"));
			BookInventory in = new BookInventory();
			in.setQty(rs.getInt("qty"));
			in.setBook(b);
			list.add(in);
		}

		return list;
	}

	public void placeOrder(BookSales b) throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into book_sales(sales_id,user_id,book_id,qty,total_amount,order_date,status) values (?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, b.getSalesId());
		pst.setInt(2, b.getUser().getId());
		pst.setInt(3, b.getBook().getId());
		pst.setInt(4, b.getQty());
		pst.setFloat(5, b.getTotalAmount());
		pst.setObject(6, b.getOrderDate());
		pst.setString(7, b.getStatus());
		String sql1 = "select book_id,qty from book_inventory where book_id = " + b.getBook().getId();
		PreparedStatement pst1 = con.prepareStatement(sql1);
		ResultSet rs = pst1.executeQuery();
		BookInventory bi = new BookInventory();
		while (rs.next()) {
			bi.setQty(rs.getInt("qty"));
		}
		if (bi.getQty() < b.getQty()) {
			System.out.println("Out of stock");
		} else {
			int rows = pst.executeUpdate();
			System.out.println("BookSales - save :" + rows);
		}
	}

	public void cancelOrder(Integer id) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update book_sales set status='cancelled' where book_id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int rows = pst.executeUpdate();
		System.out.println("Canceled : " + rows);
	}
}
