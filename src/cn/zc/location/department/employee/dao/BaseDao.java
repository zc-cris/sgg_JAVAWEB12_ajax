package cn.zc.location.department.employee.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.zc.location.department.employee.JdbcUtils;



/**
 * 	
 * @ClassName：BaseDao.java
 * @Description：TODO (实现了dao类通用操作接口的dao基类)
 * @Project Name：hrmsys
 * @Package Name: cn.zc.hrmsys.dao.baseDao
 * @Author：zc-cris
 * @Create Date：2018年1月30日下午11:27:13
 * @version: v1.0
 * @Copyright: zc-cris
 * @mail: 17623887386@163.com
 */
public class BaseDao {
	
	/**
	 * 
	 * @MethodName: getAll
	 * @Description: TODO (基类查询数据集合的方法)
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 * @throws SQLException
	 * @Return Type: List<T>
	 * @Author: zc-cris
	 */
	public <T> List<T> getAll(String sql,Class<T> clazz,Object... params) throws SQLException{
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(clazz), params);
	}

	/**
	 * 
	 * @MethodName: getOne
	 * @Description: TODO (基类查询一条数据的方法)
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 * @throws SQLException
	 * @Return Type: T
	 * @Author: zc-cris
	 */
	public <T> T getOne(String sql,Class<T> clazz,Object... params) throws SQLException {
		return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<>(clazz), params);
	}
	
}
