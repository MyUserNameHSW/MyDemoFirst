package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyy.dao.ICheck;
import com.lyy.util.DBUtils;
import com.lyy.util.MD5Tool;

public class CheckDao implements ICheck{

	@Override
	public boolean login(String name, String code) {
		boolean flag = false;
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select code from manage where name=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String password = resultSet.getString("code");
				if (password.equals(code)) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(resultSet, preparedStatement, connection);
		}
		return flag;
	}

}
