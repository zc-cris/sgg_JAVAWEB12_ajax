package cn.zc.location.department.employee.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.zc.location.department.employee.dao.BaseDao;
import cn.zc.location.department.employee.pojo.Department;
import cn.zc.location.department.employee.pojo.Emp;
import cn.zc.location.department.employee.pojo.Location;

/**
 * 	
 * @ClassName：EmployeeServlet.java
 * @Description：TODO (整个模块的控制器，用于实现location，department，employees的三级联动)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.location.department.employee.servlet
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 创建一个BaseDao基类的实例
	 */
	BaseDao baseDao = new BaseDao();

	/**
	 * 
	 * @MethodName: doGet
	 * @Description: TODO (获取请求的method参数，并通过反射调用相关方法)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @Author：zc-cris
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @MethodName: locationList
	 * @Description: TODO (查询所有的工作地址信息)
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 * @Return Type: void
	 * @Author: zc-cris
	 */
	@SuppressWarnings("unused")
	private void locationList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//如果数据库里的表字段名字和实体类的属性名不一致，则在查询的时候添加别名为实体类对应属性名即可解决
		String sql = "select location_id id,city from t_locations";
		List<Location> locations = baseDao.getAll(sql, Location.class);
		System.out.println(locations);
		request.setAttribute("locations", locations);
		request.getRequestDispatcher("/WEB-INF/pages/employee.jsp").forward(request, response);
	}
	
	/**
	 * 
	 * @MethodName: departmentList
	 * @Description: TODO (根据工作地编号查询对应的部门信息)
	 * @param request
	 * @param response
	 * @throws NumberFormatException
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException
	 * @Return Type: void
	 * @Author: zc-cris
	 */
	@SuppressWarnings("unused")
	private void departmentList(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, IOException, InterruptedException {
		String locationId = request.getParameter("locationId");
		String sql = "select department_id id,department_name name from t_departments where location_id = ?";
		List<Department> depts = baseDao.getAll(sql, Department.class, Integer.parseInt(locationId));
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(depts);
//		System.out.println(str);
		//为了测试blockUI
		Thread.sleep(1000);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		response.getWriter().println(str);
	}
	
	/**
	 * 
	 * @MethodName: empList
	 * @Description: TODO (根据部门编号查询对应的员工信息)
	 * @param request
	 * @param response
	 * @throws NumberFormatException
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException
	 * @Return Type: void
	 * @Author: zc-cris
	 */
	@SuppressWarnings("unused")
	private void empList(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, IOException, InterruptedException {
		String deptId = request.getParameter("deptId");
		String sql = "select employee_id id,employee_name name from t_employee where department_id = ?";
		List<Emp> emps = baseDao.getAll(sql, Emp.class, Integer.parseInt(deptId));
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(emps);
		//为了测试blockUI
		Thread.sleep(1000);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		response.getWriter().write(str);
	}
	
	/**
	 * 
	 * @MethodName: getEmp
	 * @Description: TODO (根据员工编号查询对应的详细信息)
	 * @param request
	 * @param response
	 * @throws NumberFormatException
	 * @throws SQLException
	 * @throws IOException
	 * @Return Type: void
	 * @Author: zc-cris
	 */
	@SuppressWarnings("unused")
	private void getEmp(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, IOException {
		String empId = request.getParameter("empId");
		String sql = "select employee_id id,employee_name name,salary,hire_date hireDate,email from t_employee where employee_id = ?";
		Emp emp = baseDao.getOne(sql, Emp.class, Integer.parseInt(empId));
		System.out.println(emp);
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(emp);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		response.getWriter().write(str);
	}
	
}
