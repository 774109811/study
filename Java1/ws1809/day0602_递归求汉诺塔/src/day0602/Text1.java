package day0602;

import java.util.Scanner;

public class Text1 {

	public static void main(String[] args) {
		System.out.println("Íæ¼¸²ãµÄººÅµËş£º");
		int n =new Scanner(System.in).nextInt();
		f(n,"A","B","C");
	}

	private static void f(int n, String z1, String z2, String z3) {
		if(n==1){
			System.out.println(z1+"->"+z3);
			return;
		}
		f(n-1,z1,z3,z2);
		f(1,z1,z2,z3);
		f(n-1,z2,z1,z3);
		
	}

}
