package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lyy.dao.IPUpdate;
import com.lyy.util.DBUtils;

public class PUpdate implements IPUpdate{


	@Override
	public void pUpdate(String name, String depict, String type, double price, String img,String phone, int PS2_id,int P_id) {
		// TODO Auto-generated method stub
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "update product set name=?,depict=?,type=?,price=?,img=?,phone=?,PS2_id=? where P_id=?";
	    try {
	    	connection.setAutoCommit(false);
	    	preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, depict);
			preparedStatement.setString(3, type);
			preparedStatement.setDouble(4, price);
			preparedStatement.setString(5, img);
			preparedStatement.setString(6, phone);
			preparedStatement.setInt(7, PS2_id);
			preparedStatement.setInt(8,P_id);
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(null, preparedStatement, connection);
		}
	}

}
