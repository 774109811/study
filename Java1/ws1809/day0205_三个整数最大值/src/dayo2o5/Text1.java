package dayo2o5;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.print( "����A;" );
		int A = new Scanner (System.in).nextInt();
		System.out.print( "����B;" );
		int B = new Scanner (System.in).nextInt();
		System.out.print( "����C;" );
		int C = new Scanner (System.in).nextInt();
		
//		int max=  A>B?A:B ;
//		max=  max>C?max:C;
		int max = A>B?(A>C?A:C ):(B>C?B:C);
        System.out.println("���ֵ"+max);		
	}
	
}
