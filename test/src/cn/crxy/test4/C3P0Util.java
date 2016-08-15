package cn.crxy.test4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	public static Connection getConnection() throws Exception{
		Connection connection = cpds.getConnection();
		return connection;
	}
	
	public static void release(ResultSet set , Statement stmt , Connection conn){
		if(set!=null){
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				set=null;
			}
			
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stmt=null;
			}
			
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn=null;
			}
			
		}
	}
	
}
