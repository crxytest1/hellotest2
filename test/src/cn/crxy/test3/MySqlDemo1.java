package cn.crxy.test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MySqlDemo1 {

	public static void main(String[] args) throws Exception {

		// 1.ע������
		DriverManager.registerDriver(new Driver());

		// 2.��������
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test2", "root", "root");

		// 3.��ȡ����Sql��������.
		Statement stmt = conn.createStatement();

		// 4.����SQL.
		ResultSet rs = stmt.executeQuery("select * from student where no=1");
		
		// 5.��ȡ���������
		while( rs.next() ){
			int int1 = rs.getInt("no");
			String string = rs.getString("name");
			String string2 = rs.getString("sex");
			System.out.println(int1+" -- "+string+" -- "+string2);
		}
		
		// 6.�ر�����.
		rs.close();
		stmt.close();
		conn.close();

	}

}
