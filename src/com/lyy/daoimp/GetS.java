package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyy.dao.IGetS;
import com.lyy.util.DBUtils;

public class GetS implements IGetS{

	@Override
	public int getS(String name) {
		int S_id = 1 ;
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select S_id from manage where name=? limit 1";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				S_id = resultSet.getInt("S_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(resultSet, preparedStatement, connection);
		}
		
		return S_id;
	}

}
