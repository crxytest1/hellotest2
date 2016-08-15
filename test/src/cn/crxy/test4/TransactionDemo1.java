package cn.crxy.test4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import cn.crxy.test3.JdbcUtil;

public class TransactionDemo1 {

	@Test
	public void test1() {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		Savepoint ss  = null;
		
		try {
			connection = JdbcUtil.getConnection();
			
			//开启事物: 只要关闭自动提交事物即可.
			connection.setAutoCommit(false);
			
			prepareStatement = connection
					.prepareStatement("insert into student (name,sex) values (?,?)");

			prepareStatement.setString(1, "小花2");
			prepareStatement.setString(2, "男");

			int executeUpdate = prepareStatement.executeUpdate();

			if (executeUpdate != 0) {
				System.out.println("1执行成功:" + executeUpdate + "!");
			}
			
			ss = connection.setSavepoint();
			
			
			prepareStatement = connection
					.prepareStatement("insert into student (no,name,sex) values (1,?,?)");

			prepareStatement.setString(1, "小花2");
			prepareStatement.setString(2, "男");

			 executeUpdate = prepareStatement.executeUpdate();

			if (executeUpdate != 0) {
				System.out.println("2执行成功:" + executeUpdate + "!");
			}
		} catch (Exception e) {
			//出问题就回滚.
			try {
				connection.rollback(ss);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		} finally {
			
			//无论是否回滚都需要进行commit提交.因为不具备自动提交能力了!
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			JdbcUtil.release(null, prepareStatement, connection);
		}
	}

}
