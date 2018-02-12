package cn.zc.shopping;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 	
 * @ClassName：ShoppingServlet.java
 * @Description：TODO (处理用户将商品添加至购物车的控制器)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.shopping
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
@WebServlet("/add")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * 
	 * @MethodName: doPost
	 * @Description: TODO (对用户添加商品至购物车的请求进行处理)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @Author：zc-cris
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先从session中获取购物车类
		ShoppingCart sc = (ShoppingCart) request.getSession().getAttribute("sc");
		if(sc == null) {
			sc = new ShoppingCart();
			request.getSession().setAttribute("sc", sc);
		}
		//调用购物车类自身的方法添加商品
		sc.add(request.getParameter("name"), request.getParameter("price"));
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		
		//使用jackson工具包完成java类到json的转换
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(sc);
		System.out.println(str);
		response.getWriter().write(str);
		
		//使用json包完成java类到json的转换（这种方法太过麻烦）
//		int totalCount = sc.getAllCount();
//		int totalPrice = sc.getAllPrice();
//		JSONObject object = new JSONObject();
//		try {
//			object.put("allCount", totalCount);
//			object.put("allPrice", totalPrice);	
//			object.put("bookName", request.getParameter("name"));	
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		System.out.println(object.toString());
//		response.getWriter().write(object.toString());
		
	}
}
