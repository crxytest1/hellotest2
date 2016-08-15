package cn.crxy.test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class MySqlDemo2 {
	
	//�������ȡ�ʹ��ݲ������Ǵ�1λ�ÿ�ʼ.
	
	//��������
	@Test
	public void test1() throws Exception{
		Connection connection = JdbcUtil.getConnection();
		
		PreparedStatement prepareStatement = connection.prepareStatement("insert into student (name,sex) values (?,?)");
		
		prepareStatement.setString(1, "С��");
		prepareStatement.setString(2, "��");
		
		int executeUpdate = prepareStatement.executeUpdate();
		
		if( executeUpdate!=0 ){
			System.out.println("ִ�гɹ�:"+executeUpdate+"!");
		}
		
		JdbcUtil.release(null, prepareStatement, connection);
		
	}

	
	//��ѯ����
		@Test
		public void test2() throws Exception{
			Connection connection = JdbcUtil.getConnection();
			
			PreparedStatement prepareStatement = connection.prepareStatement("select * from student where no = ?");
			
			prepareStatement.setString(1, "1");
			
			 ResultSet executeQuery = prepareStatement.executeQuery();
			
			 while( executeQuery.next() ){
				 int no = executeQuery.getInt(1);
				 String name = executeQuery.getString(2);
				 System.out.println(no+" -- "+name);
			 }
			 
			JdbcUtil.release(executeQuery, prepareStatement, connection);
			
		}
}
