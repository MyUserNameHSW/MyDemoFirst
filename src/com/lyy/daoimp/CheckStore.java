package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyy.dao.ICheckStore;
import com.lyy.util.DBUtils;

public class CheckStore implements ICheckStore{

	@Override
	public boolean checkStore(int S_id) {
		// TODO Auto-generated method stub
		boolean flag = true;
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select S_id from manage where S_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, S_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(resultSet, preparedStatement, connection);
		}
		return flag;
	}
}
