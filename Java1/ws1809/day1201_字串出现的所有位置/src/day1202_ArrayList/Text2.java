package day1202_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("ÇëÊäÈë×Ö·û´®£º");
		String s= new Scanner(System.in).nextLine();
		System.out.println("ÇëÊäÈë×Ö´®£º");
		String  t = new Scanner(System.in).nextLine();
		 ArrayList<Integer> list=find(s,t);
		for(Integer i:list ){
			System.out.println(i);
		}
		 
	}

	private static ArrayList<Integer> find(String s, String t) {
		int from = 0;
		ArrayList<Integer> list = new ArrayList<>();
		 while(true){			 
		 from = s.indexOf(t,from);
		 if(from == -1){
			 break;
		 }
		 list.add(from);
		 from++;
		 }
		return list;
	}
}
