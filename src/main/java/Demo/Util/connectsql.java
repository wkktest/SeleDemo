package Demo.Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class connectsql {
	protected static logUtil logger = new logUtil();
	protected static String sql_type = "com.mysql.jdbc.Driver";
	protected static String mysqlurl = "jdbc:mysql://192.168.40.111:3306/test";
	protected static String mysql_user = "root";
	protected static String mysql_pwd = "root";
	
	public static void Select(String tablename,String sqlselect) throws ClassNotFoundException, SQLException{
			// 设定mysql驱动
			Class.forName(sql_type);
			// 建立数据库连接
			Connection conn = (Connection) DriverManager.getConnection(mysqlurl, mysql_user, mysql_pwd);
			// 判断数据库连接是否成功
			if (!conn.isClosed()) {
				System.out.println("数据库连接成功");
				logger.info("数据库连接成功");
			} else {
				System.out.println("数据库连接失败");
				logger.error("数据库连接失败");
			}
			// 创建Statement对象可以用对应的方法executeQuery(sql语句)获取测试数据
			Statement sta = (Statement) conn.createStatement();
			// 创建一个结果集存放数据库执行完sql的数据
			ResultSet rs = sta.executeQuery(sqlselect);
			
			System.out.println(rs);

	}
}
