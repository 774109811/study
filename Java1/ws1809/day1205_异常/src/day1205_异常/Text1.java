package day1205_�쳣;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		while(true){
			try {
				f1();
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("��������������");
			}catch(ArithmeticException e){
				System.out.println("����������0");
			}catch(Exception e){
				System.out.println("����������������룺");
			}finally{
				System.out.println("\n----------");
			}
		}
//		��main�����쳣
		
	}

	private static void f1() {
		System.out.println("���붺�Ÿ���");
		String s= new Scanner(System.in).nextLine();
		 String [] a = s.split(",");
		int n1 =Integer.parseInt(a[0]);
		int n2 =Integer.parseInt(a[1]);
		int r =n1/n2;
		System.out.println(r);
	}
}
