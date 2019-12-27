package day04;

import java.util.Scanner;

public class Tex3 {
	public static void main(String[] args) {
		System.out.println("Êý£º");
		int a=new Scanner(System.in).nextInt();
		String r="";
		for(int i=0;i<32;i++){
			int t =1<<i;
			int b=t&a;
			if(b==0){
			    r=0+r;
			}else{
				r=1+r;
			}
		}
		System.out.println(r);
		
	}
}
