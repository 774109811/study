package day0603;

public class Text1 {
	public static void main(String[] args) {
//		新建Sold
		Soldier s1=new Soldier();
		Soldier s2=new Soldier();
		
		//用s1找到对象的内存空间
		//访问这个对象的Id变量
		s1.id=9527;
		s2.id=9528;
		
		s1.go();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		
	}
}
