package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyy.action.Product;
import com.lyy.dao.IGetCount;
import com.lyy.util.DBUtils;
import com.lyy.util.PageNums;

public class GetCount implements IGetCount{

	@Override
	public int getCount(int S_id) {
		// TODO Auto-generated method stub
		int results = 0;
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select count(*) from product where S_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, S_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				results = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(resultSet, preparedStatement, connection);
		}
		return results;
	}

	@Override
	public int getSelectCount(int S_id, String likename) {
		// TODO Auto-generated method stub
		int count = 0;
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM product WHERE S_id=? AND (P_id LIKE ? OR NAME LIKE ? OR depict LIKE ? OR TYPE LIKE ? OR price LIKE ? OR img LIKE ? OR buy_num LIKE ? OR col_num LIKE ? OR phone LIKE ? OR PS2_id LIKE ?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, S_id);
			preparedStatement.setString(2, "%" + likename + "%");
			preparedStatement.setString(3, "%" + likename + "%");
			preparedStatement.setString(4, "%" + likename + "%");
			preparedStatement.setString(5, "%" + likename + "%");
			preparedStatement.setString(6, "%" + likename + "%");
			preparedStatement.setString(7, "%" + likename + "%");
			preparedStatement.setString(8, "%" + likename + "%");
			preparedStatement.setString(9, "%" + likename + "%");
			preparedStatement.setString(10, "%" + likename + "%");
			preparedStatement.setString(11, "%" + likename + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count++;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(resultSet, preparedStatement, connection);
		}
		return count;
	}

	@Override
	public int getListCount(int S_id, String item) {
		// TODO Auto-generated method stub
		int count = 0;
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from product where S_id=? and type=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, S_id);
			preparedStatement.setString(2,item);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(resultSet, preparedStatement, connection);
		}
		return count;
	}

}
