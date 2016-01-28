package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.lyy.action.Product;
import com.lyy.dao.ISelectPage;
import com.lyy.util.DBUtils;
import com.lyy.util.PageNums;

public class SelectPage implements ISelectPage {
	public int count = 0;

	@Override
	public List<Product> show(int S_id, String likename, int pageNum) {

		List<Product> list = new ArrayList<>();
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM product WHERE S_id=? AND (P_id LIKE ? OR NAME LIKE ? OR depict LIKE ? OR TYPE LIKE ? OR price LIKE ? OR img LIKE ? OR buy_num LIKE ? OR col_num LIKE ? OR phone LIKE ? OR PS2_id LIKE ?) limit ?,?";
		int m = (pageNum - 1) * PageNums.PAGENUM;
		int n = PageNums.PAGENUM;
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
			preparedStatement.setInt(12, m);
			preparedStatement.setInt(13, n);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count++;
				int p_id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				// int s_id = resultSet.getInt(3);
				String depict = resultSet.getString(4);
				String type = resultSet.getString(5);
				double price = resultSet.getDouble(6);
				String img = resultSet.getString(7);
				int buy_num = resultSet.getInt(8);
				int col_num = resultSet.getInt(9);
				String phone = resultSet.getString(10);
				int PS2_id = resultSet.getInt(11);
				Product product = new Product(p_id, name, depict, type, price, img, buy_num, col_num, phone, PS2_id);
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.release(resultSet, preparedStatement, connection);
		}
		return list;
	}

}
