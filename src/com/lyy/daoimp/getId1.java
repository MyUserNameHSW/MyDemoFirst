package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyy.dao.IGetId1;
import com.lyy.util.DBUtils;

public class getId1 implements IGetId1{

	@Override
	public String PS2_Name(int PS2_id) {
		String result = null;
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select ps_name from psort2 where PS2_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, PS2_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				 result = resultSet.getString("ps_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
