package cn.zc.test.jackson;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 	
 * @ClassName：User.java
 * @Description：TODO (对jackson工具包进行测试)
 * @Project Name：sgg_JAVAWEB12_ajax
 * @Package Name: cn.zc.test.jackson
 * @Author：zc-cris
 * @version: v1.0
 * @Copyright: zc-cris
 * @email: 17623887386@163.com
 */
public class User {

	private String name;
	private Integer id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	public User() {
		super();
		
	}
	public String getAddress() {
		return "北京";
	}
	@JsonIgnore
	public String getBirth() {
		return "1993-11-05";
	}
	public static void main(String[] args) throws JsonProcessingException {
		//测试一个java类转换为json格式的字符串
		ObjectMapper mapper = new ObjectMapper();
		User user = new User("james", 1001);
		String jsonStr = mapper.writeValueAsString(user);
		System.out.println(jsonStr);
		
		//测试java集合转换为json格式的字符串
		List<User> lists = Arrays.asList(user,new User("老猪", 1002));
		jsonStr = mapper.writeValueAsString(lists);
		System.out.println(jsonStr);
	}
}


