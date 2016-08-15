package cn.crxy.test4;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

public class C3p0Demo2 {
	
	@Test
	public void test1() throws Exception{
		Connection connection = C3P0Util.getConnection();
		
		PreparedStatement prepareStatement = connection.prepareStatement("insert into student (name,sex) values (?,?)");
		prepareStatement.setString(1, "xiaoming");
		prepareStatement.setString(2, "女");
		
		int executeUpdate = prepareStatement.executeUpdate();
		if(executeUpdate!=0){
			System.out.println("添加成功!");
		}
		C3P0Util.release(null, prepareStatement, connection);
		
	}
	
}
