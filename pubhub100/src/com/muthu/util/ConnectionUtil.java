package com.muthu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection getConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/pubhub100", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}
