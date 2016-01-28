package com.lyy.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lyy.dao.IPDelete;
import com.lyy.util.DBUtils;

public class PDelete implements IPDelete{

	@Override
	public void pDelete(int P_id) {
		// TODO Auto-generated method stub
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "delete from product where P_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, P_id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.release(null, preparedStatement, connection);
		}
	}

}
