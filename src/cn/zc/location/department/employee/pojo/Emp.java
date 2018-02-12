package cn.zc.location.department.employee.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 	
 * @ClassName：Emp.java
 * @Description：TODO (员工表对应的实体类)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.location.department.employee.pojo
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
public class Emp {
	private Integer id;
	private String name;
	private String email;
	private Date hireDate;
	private BigDecimal salary;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Emp(Integer id, String name, String email, Date hireDate, BigDecimal salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.hireDate = hireDate;
		this.salary = salary;
	}
	public Emp() {
		super();
		
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", email=" + email + ", hireDate=" + hireDate + ", salary=" + salary
				+ "]";
	}
	
}
