package day1105_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Text1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(111);
		list.add(222);
		list.add(333);
		list.add(111);
		list.add(222);
		list.add(333);
		list.add(555);
		list.add(555);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(4));
		System.out.println(list.remove(4));
		System.out.println(list);
		System.out.println(list.remove(Integer.valueOf(111)));
		System.out.println(list);
		
		for(int i =0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		 Iterator<Integer> it = list.iterator();
		 while(it.hasNext()){
			 int t =it.next();
			 System.out.println(t);
		 }
	}
}
