package day1803;

public class A {
	
	@Text(id =1,value="���Դ���1")
	public void   a() {
		System.out.println("A.a");
	}
	
	public void   b() {
		System.out.println("A.b");
	}
	@Text(id=2)
	public void   c() {
		System.out.println("A.c");
	}
	@Text("���Դ���3")
	public void   f() {
		System.out.println("A.d");
	}

}
