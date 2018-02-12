package cn.zc.name.validate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	
 * @ClassName：UserNameInvalidate.java
 * @Description：TODO (对用户名进行检测的类)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.name.validate
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
@WebServlet("/validateUserName")
public class UserNameInvalidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @MethodName: doPost
	 * @Description: TODO (对前台传来的用户名进行校验)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @Author：zc-cris
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> lists = Arrays.asList("ccc","bbb","aaa");
		String userName = request.getParameter("userName");
		String str = null;
		if(lists.contains(userName)) {
			str = "<font color='red'>该用户名已经被使用！！！</font>";
		}else {
			str = "<font color='pink'>该用户名可以被使用！！！</font>";
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(str);
	}
}
