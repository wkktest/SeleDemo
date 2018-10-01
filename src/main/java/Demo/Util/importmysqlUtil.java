package Demo.Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class importmysqlUtil {

	 private static logUtil logger = new logUtil(importmysqlUtil.class); 
	
	/**
	 * 读取mysql数据库中的数据
	 * 
	 * @param tableName
	 * 
	 * @param sql_type   : 链接数据库的种类
	 * @param mysqlurl   : 数据库url
	 * @param mysql_user : 数据库用户名
	 * @param mysql_pwd  : 数据库密码
	 
	 * @return results   ：二维数组数据
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	static String sql_type = "com.mysql.jdbc.Driver";
	static String mysqlurl = "jdbc:mysql://192.168.40.111:3306/test";
	static String mysql_user = "root";
	static String mysql_pwd = "root";

	public static Object[][] readmysql(String tableName) throws ClassNotFoundException, SQLException {
		
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
		ResultSet rs = sta.executeQuery("select * from loginbase");

		// 声明存放泛型string数组的list对象
		List<Object[]> listStr = new ArrayList<Object[]>();
		int colNum = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			String[] str = new String[colNum];
			for (int i = 0; i < str.length; i++) {
				// System.out.println(rs.getString(i+1).toString());
				// resultSet数据集的getString下标是从1开始的
				str[i] = rs.getString(i + 1);
			}
			listStr.add(str);
		}
		// 关闭数据集
		rs.close();
		// 关闭连接
		conn.close();

		// 将list对象数据转换成二维数组
		Object[][] results = new Object[listStr.size()][];
		for (int i = 0; i < listStr.size(); i++) {
			results[i] = listStr.get(i);
		}
		return results;
	}

}
