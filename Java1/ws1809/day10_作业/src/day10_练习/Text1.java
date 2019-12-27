package day10_练习;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("输入一个字符串：");
		String a= new Scanner(System.in).nextLine();
		System.out.println("输入要查找的字符：");
		String b= new Scanner(System.in).nextLine();
		int i=0;
		while(a.indexOf(b,i)!=-1){
			System.out.println(a.indexOf(b,i));
			i=a.indexOf(b,i)+1;
		}
		
		
		
		
//		for(int i=0;i<a.length();i++){
//			int index =a.indexOf(b,i);
//			if(index!=-1){
//				System.out.println(index);
//				index=index+1;
//				break;
//			}
//			}
//				
//			}
		}
		
//		 int index =s.indexOf("bc");
//	
//		 System.out.println(index);
	}

