package cn.zc.location.department.employee.pojo;

/**
 * 	
 * @ClassName：Location.java
 * @Description：TODO (工作城市表对应的实体类)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.location.department.employee.pojo
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
public class Location {
	private Integer id;
	private String city;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Location() {
		super();
		
	}
	public Location(Integer id, String city) {
		super();
		this.id = id;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + "]";
	}
	

}
