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
			
			//��������: ֻҪ�ر��Զ��ύ���Ｔ��.
			connection.setAutoCommit(false);
			
			prepareStatement = connection
					.prepareStatement("insert into student (name,sex) values (?,?)");

			prepareStatement.setString(1, "С��2");
			prepareStatement.setString(2, "��");

			int executeUpdate = prepareStatement.executeUpdate();

			if (executeUpdate != 0) {
				System.out.println("1ִ�гɹ�:" + executeUpdate + "!");
			}
			
			ss = connection.setSavepoint();
			
			
			prepareStatement = connection
					.prepareStatement("insert into student (no,name,sex) values (1,?,?)");

			prepareStatement.setString(1, "С��2");
			prepareStatement.setString(2, "��");

			 executeUpdate = prepareStatement.executeUpdate();

			if (executeUpdate != 0) {
				System.out.println("2ִ�гɹ�:" + executeUpdate + "!");
			}
		} catch (Exception e) {
			//������ͻع�.
			try {
				connection.rollback(ss);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		} finally {
			
			//�����Ƿ�ع�����Ҫ����commit�ύ.��Ϊ���߱��Զ��ύ������!
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			JdbcUtil.release(null, prepareStatement, connection);
		}
	}

}
