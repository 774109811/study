package day0705;

import java.util.Random;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("按回车开始");
		while(true){
			int r =new Random().nextInt(4);
			switch(r){
			case 0:System.out.println("抽象类不能创建实例");break;
			case 1:f(new Line() );break;
			case 2:f(new Square());break;
			case 3:f(new Circle());break;
			}
		}
	}
	static void f(Shape s){
		 new Scanner(System.in).nextLine();
		 s.draw();
//		 s的真实类型是Line类型
		 if(s instanceof Line){	
			 
//		 详细转型，对Line类型对象进行特殊处理强制（）
		 Line line =(Line)s;
		 line.length();
		 }
	       new Scanner(System.in).nextLine();
		 s.clear();
		 
	}
}
