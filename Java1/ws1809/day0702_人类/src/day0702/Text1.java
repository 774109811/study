package day0702;

public class Text1 {
	public static void main(String[] args) {
		Person p=new Person("����","��",25);
		Student s=new Student();
		Employee e=new Employee();
		Me m=new Me();
		m.time=100;
		m.name="sb";
		s.school="˹̹����ѧ";
		s.name="����";
		s.age=12;
		s.gender="Ů";
		e.name="�Ʒ�";
		e.age=15;
		e.gender="Ů";
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
		System.out.println("\n\n--���������ʹ���---");
		System.out.println(p.toString());
	}
	
}
