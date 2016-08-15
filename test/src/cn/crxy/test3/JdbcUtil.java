package cn.crxy.test3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil {
	
	private static String classname;
	private static String name;
	private static String pass;
	private static String url;
	
	
	
	//加载驱动.
	static{
		try {
			FileInputStream fis = new FileInputStream("src/dbinfo.properties");
			Properties pro = new Properties();
			pro.load(fis);
			
			classname = pro.get("classname").toString();
			 name = pro.get("username").toString();
			 pass = pro.get("password").toString();
			 url = pro.get("url").toString();
			Class.forName(classname);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, name, pass);
	}
	//释放连接
	public static void release( ResultSet rs, Statement stmt , Connection conn ){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
		
		
	}
	
	
}
