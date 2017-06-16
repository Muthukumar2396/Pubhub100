package com.muthu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muthu.model.Book;
import com.muthu.util.ConnectionUtil;

public class BookSearchDAO {
	public List<Book> findAll() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status from book";
		PreparedStatement pst = con.prepareStatement(sql);

		return search(pst);
	}

	public List<Book> findByTitle(String title) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status from book where title = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, title);
		return search(pst);

	}

	public List<Book> findByAuthor(String author) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status from book where author = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, author);
		return search(pst);

	}

	public List<Book> findByPrice(Float one, Float two) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status from book where (price BETWEEN ? AND ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setFloat(1, one);
		pst.setFloat(2, two);
		return search(pst);

	}

	public List<Book> findById(Integer id) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status from book where id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		return search(pst);

	}

	private List<Book> search(PreparedStatement pst) throws SQLException {
		List<Book> list = new ArrayList<Book>();
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
			list.add(b);
		}

		return list;
	}
}
