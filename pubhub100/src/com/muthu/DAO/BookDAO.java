package com.muthu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muthu.model.Book;
import com.muthu.util.ConnectionUtil;

public class BookDAO {
	public void save(Book b) throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into book(id,title,author,publishDate,content,price,status) values (?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, b.getId());
		pst.setString(2, b.getTitle());
		pst.setString(3, b.getAuthor());
		pst.setObject(4, b.getPublishDate());
		pst.setString(5, b.getContent());
		pst.setLong(6, (long) b.getPrice());
		pst.setString(7, b.getStatus());

		int rows = pst.executeUpdate();
		System.out.println("Book - save :" + rows);

	}

	public void uploadContent(Integer id, String content) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update book set content= ? where id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, content);
		pst.setLong(2, id);
		int rows = pst.executeUpdate();
		System.out.println("Updated : " + rows);

	}

	public List<Book> findAll() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status from book";
		PreparedStatement pst = con.prepareStatement(sql);

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

	public void delete(Integer id) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "delete from book where id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int rows = pst.executeUpdate();
		System.out.println("Deleted : " + rows);
	}

	public List<Book> findByAuthor(String author) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status from book where author = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, author);
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

	public List<Book> findById(Integer id) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status from book where id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
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
