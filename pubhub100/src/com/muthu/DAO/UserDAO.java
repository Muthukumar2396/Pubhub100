package com.muthu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muthu.model.Book;
import com.muthu.model.BookInventory;
import com.muthu.model.User;
import com.muthu.util.ConnectionUtil;

public class UserDAO {

	public void save(User u) throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into user(id,name,username,password,mobile_no,email_id,active,role) values (?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, u.getId());
		pst.setString(2, u.getName());
		pst.setString(3, u.getUsername());
		pst.setString(4, u.getPassword());
		pst.setLong(5, u.getMobileNo());
		pst.setString(6, u.getEmailId());
		pst.setString(7, u.getActive());
		pst.setString(8, u.getRole());

		int rows = pst.executeUpdate();
		System.out.println("User - save :" + rows);

	}

	public List<User> findAll() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,name,username,mobile_no,email_id,active,role from user";
		PreparedStatement pst = con.prepareStatement(sql);

		List<User> list = new ArrayList<User>();
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setUsername(rs.getString("username"));
			u.setMobileNo(rs.getLong("mobile_no"));
			u.setEmailId(rs.getString("email_id"));
			u.setActive(rs.getString("active"));
			u.setRole(rs.getString("role"));
			list.add(u);
		}

		return list;
	}
	public User login(String username, String password) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,name,username,mobile_no,email_id,active,role from user where username= ? and password= ? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);

		User u = null;
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setUsername(rs.getString("username"));
			u.setMobileNo(rs.getLong("mobile_no"));
			u.setEmailId(rs.getString("email_id"));
			u.setActive(rs.getString("active"));
			u.setRole(rs.getString("role"));
		}

		return u;

	}
	public void resetPassword(String username1,String password) throws SQLException{
		Connection con = ConnectionUtil.getConnection();
		String sql = "update user set password= ? where username = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, password);
		pst.setString(2, username1);
		int rows = pst.executeUpdate();
		System.out.println("Updated : " + rows);
	}
	public List<BookInventory> ViewAll() throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,title,author,publishdate,content,price,status,qty from book,book_inventory where qty>0 and id = book_id ";
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
}
