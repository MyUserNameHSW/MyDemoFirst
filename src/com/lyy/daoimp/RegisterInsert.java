package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lyy.dao.IRegisterInster;
import com.lyy.util.DBUtils;
import com.lyy.util.MD5Tool;

public class RegisterInsert implements IRegisterInster {

	@Override
	public void registerInsert(String name, String code,int S_id) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into manage values (null,?,?,?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, code);
			preparedStatement.setInt(3, S_id);
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
		} finally {
			DBUtils.release(null, preparedStatement, connection);
		}
	}
}
