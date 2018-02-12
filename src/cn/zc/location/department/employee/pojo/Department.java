package cn.zc.location.department.employee.pojo;

/**
 * 	
 * @ClassName：Department.java
 * @Description：TODO (部门表对应的实体类)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.location.department.employee.pojo
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
public class Department {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Department() {
		super();
		
	}
}
