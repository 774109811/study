package day12_学生分数;

public class Student {
	private int id;
	private int age;
	private String name;
	private String gender;
	
	public Student() {
		super();
	}
	public Student(int id, int age, String name, String gender) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		
		return "姓名: "+name+" 性别: "+gender+" 年龄: "+age+" 学号: "+id;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj ==this ) return true;
		if(!(obj instanceof Student)) return false;
		Student s = (Student)obj;
		return id == s.id && age == s.age&&
				name == s.name && gender == s.gender; 
	}
	@Override
	public int hashCode() {
		int s = 31;
		int r = 1 ;
		r = r*s+ id;
		r = r*s+ age;
		r = r*s+name.hashCode();
		r = r*s+gender.hashCode();
		return r ;
	}
}
