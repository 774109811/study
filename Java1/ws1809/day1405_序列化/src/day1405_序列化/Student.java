package day1405_ĞòÁĞ»¯;
import java.io.Serializable;
public class Student implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2018L;
	private int id;
	private String name;
	private static String gender;
	private transient int age;
	

	public Student() {
		super();
	}
	public Student(int id, String name, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + "]";
	}
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getGender() {
		return gender;
	}
	void setGender(String gender) {
		this.gender = gender;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}

}
