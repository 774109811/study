package day0702;

public class Text1 {
	public static void main(String[] args) {
		Person p=new Person("张三","男",25);
		Student s=new Student();
		Employee e=new Employee();
		Me m=new Me();
		m.time=100;
		m.name="sb";
		s.school="斯坦福大学";
		s.name="花花";
		s.age=12;
		s.gender="女";
		e.name="菲菲";
		e.age=15;
		e.gender="女";
		e.salary=8000;
		System.out.println(p.toString());
		System.out.println(s.toString());
		System.out.println(e.toString());
		System.out.println(m.toString());
		f(p);		
		f(s);
		f(e);
				
		
	}
	
	static void f(Person p){
		System.out.println("\n\n--当作父类型处理---");
		System.out.println(p.toString());
	}
	
}
