package day0107;

import java.util.Scanner;
public class Text1 {
	public static void main (String[]args){
		System.out.print("请输入降落时间（秒）：");
		double t = new Scanner(System.in).nextDouble();
		double d = 0.5 * 0.89 * t ;
		System.out.println(t+"秒"+d+"米") ;
		
	}

}
