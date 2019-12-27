package day0105;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("请输入圆的半径（r）：");
		
		double r = new Scanner(System.in).nextDouble();
		double d = 2 * 3.14 * r;
		double s = 3.14 * r * r;
		System.out.println("元的周长是："+ d );
	    System.out.println("元的面积是："+ s );
		
				
		
		
	}
}
