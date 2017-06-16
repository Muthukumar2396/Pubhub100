package com.muthu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.muthu.model.BookRatings;
import com.muthu.util.ConnectionUtil;

public class BookRatingsDAO {
	public void save(BookRatings br) throws Exception {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into book_ratings(user_id,book_id,ratings) values (?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, br.getUser().getId());
		pst.setInt(2, br.getBook().getId());
		pst.setInt(3, br.getRatings());
		if(br.getRatings()<=5)
		{
		int rows = pst.executeUpdate();
		
		System.out.println("Ratings - save :" + rows);
		}
		else{
			System.out.println("Ratings should be between 1-5");
		}
	}
}
