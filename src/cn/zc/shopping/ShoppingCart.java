package cn.zc.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 * 	
 * @ClassName：ShoppingCart.java
 * @Description：TODO (需要存储在session中的购物车类)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.shopping
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
public class ShoppingCart {
	
	/**
	 * 使用HashMap来存储购物车中的商品，键：商品名字，值：商品类
	 */
	private Map<String, ShoppingCartItem> maps = new HashMap<>();
	
	/**
	 * 用来表示当前放入购物车的商品名字，为了在页面上进行显示 
	 */
	private String bookName;
	
	/**
	 * 
	 * @MethodName: add
	 * @Description: TODO (往购物车添加商品的方法)
	 * @param name
	 * @param price
	 * @Return Type: void
	 * @Author: zc-cris
	 */
	public void add(String name,String price) {
		this.bookName = name;
		ShoppingCartItem item = new ShoppingCartItem(name,1,Integer.parseInt(price));
		//使用map自带的方法来判断键是否重复（String类型已经重写了hashCode和equals方法）
		if(maps.containsKey(name)) {
			int count = maps.get(name).getCount();
			maps.get(name).setCount(count+1);
		}else {
			maps.put(name, item);
		}
	}
	/**
	 * 
	 * @MethodName: getBookName
	 * @Description: TODO (获取当前添加的商品的名称)
	 * @return
	 * @Return Type: String
	 * @Author: zc-cris
	 */
	public String getBookName() {
		return bookName;
	}
	
	/**
	 * 
	 * @MethodName: getAllCount
	 * @Description: TODO (获取当前购物车中的商品数量)
	 * @return
	 * @Return Type: int
	 * @Author: zc-cris
	 */
	public int getAllCount() {
		int count = 0;
		for(ShoppingCartItem item : maps.values()) {
			count += item.getCount();
		}
		return count;
	}
	
	/**
	 * 
	 * @MethodName: getAllPrice
	 * @Description: TODO (获取当前购物车中商品总价格)
	 * @return
	 * @Return Type: int
	 * @Author: zc-cris
	 */
	public int getAllPrice() {
		int price = 0;
		for(ShoppingCartItem item : maps.values()) {
			price += item.getPrice()*item.getCount();
		}
		return price;
	}

}
