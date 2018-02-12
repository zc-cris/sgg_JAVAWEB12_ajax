package cn.zc.location.department.employee;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 	
 * @ClassName：JdbcUtils.java
 * @Description：TODO (使用c3p0连接数据库的工具类，提供了Connection接口和QueryRunner接口的实例)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.location.department.employee
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
public class JdbcUtils {
	private static DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}
	public static void main(String[] args) {
		System.out.println(JdbcUtils.getQueryRunner());
	}
}
