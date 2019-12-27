package day1205_异常;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		while(true){
			try {
				f1();
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("请输入两个！！");
			}catch(ArithmeticException e){
				System.out.println("除数不能数0");
			}catch(Exception e){
				System.out.println("输入错误，请重新输入：");
			}finally{
				System.out.println("\n----------");
			}
		}
//		在main捕获异常
		
	}

	private static void f1() {
		System.out.println("输入逗号隔开");
		String s= new Scanner(System.in).nextLine();
		 String [] a = s.split(",");
		int n1 =Integer.parseInt(a[0]);
		int n2 =Integer.parseInt(a[1]);
		int r =n1/n2;
		System.out.println(r);
	}
}
