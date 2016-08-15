package cn.crxy.test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MySqlDemo1 {

	public static void main(String[] args) throws Exception {

		// 1.注册驱动
		DriverManager.registerDriver(new Driver());

		// 2.建立连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test2", "root", "root");

		// 3.获取操作Sql操作对象.
		Statement stmt = conn.createStatement();

		// 4.操作SQL.
		ResultSet rs = stmt.executeQuery("select * from student where no=1");
		
		// 5.获取操作结果。
		while( rs.next() ){
			int int1 = rs.getInt("no");
			String string = rs.getString("name");
			String string2 = rs.getString("sex");
			System.out.println(int1+" -- "+string+" -- "+string2);
		}
		
		// 6.关闭连接.
		rs.close();
		stmt.close();
		conn.close();

	}

}
