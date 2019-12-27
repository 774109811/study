package day1301_throw异常;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Text1 {
	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		while(true){
		try{
			System.out.println("请输入两个浮点数：");
		
			double a =new Scanner(System.in).nextDouble();
			double b =new Scanner(System.in).nextDouble();
			double r = divide(a,b);
			System.out.println(r);
			break;
		}catch(InputMismatchException e){
			System.out.println("格式错误，请重写输入");
		}
		catch(Exception e){
			System.out.println("格式错误，请重写输入");
//			e.printStackTrace();
		}
		}
	}

	private static double divide(double a, double b) {
//	
//		if()){
//			InputMismatchException e = new InputMismatchException();
//			throw e;
//		}
		if(b==0){
			ArithmeticException e = new ArithmeticException("/ by zero");
			throw e;
		}
		return a/b;
	}
}
