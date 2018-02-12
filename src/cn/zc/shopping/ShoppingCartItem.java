package cn.zc.shopping;

/**
 * 	
 * @ClassName：ShoppingCartItem.java
 * @Description：TODO (往购物车类里面放入商品类)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.shopping
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
public class ShoppingCartItem {

	/**
	 * 商品的名字
	 */
	private String name;
	
	/**
	 * 相同商品的数量
	 */
	private int count;
	
	/**
	 * 商品的价格
	 */
	private int price;
	
	public ShoppingCartItem() {
		super();
	}
	
	public ShoppingCartItem(String name, int count,int price) {
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ShoppingCartItem [name=" + name + ", count=" + count + ", price=" + price + "]";
	}
	
}
