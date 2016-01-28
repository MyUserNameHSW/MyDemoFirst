package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lyy.dao.IPInsert;
import com.lyy.util.DBUtils;

public class PInsert implements IPInsert{

	@Override
	public void pinsert(String sname,String name, String depict, String type, double price, String img,String phone, int PS2_id) {
		    GetS getS = new GetS();
		    int S_id =
		    		+getS.getS(sname);
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = null;
            String sql = "insert into product (name, S_id, depict, type, price, img,phone,PS2_id) values (?,?,?,?,?,?,?,?)";
	        try {
	        	connection.setAutoCommit(false);
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, S_id);
				preparedStatement.setString(3, depict);
				preparedStatement.setString(4, type);
				preparedStatement.setDouble(5, price);
				preparedStatement.setString(6, img);
				preparedStatement.setString(7, phone);
				preparedStatement.setInt(8, PS2_id);
				preparedStatement.execute();
				connection.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				DBUtils.release(null, preparedStatement, connection);
			}
	}

}
