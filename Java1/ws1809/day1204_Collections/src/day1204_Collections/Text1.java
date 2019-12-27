package day1204_Collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Text1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list, 
				"6","65","2","26","21","3","1",
				"37","30","11");
		System.out.println(list);
		Collections.sort(list);//ÅÅÐò
		System.out.println(list);
		
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int a = Integer.parseInt(o1);
				int b = Integer.parseInt(o2);
				 return a-b;
				
			}
			
		};
//		comp±È½ÏÆ÷ÖØÐ´
		Collections.sort(list,comp);//
		System.out.println(list);
		System.out.println("\n---------------");
		for (Iterator it = list.iterator(); it.hasNext();) {
			String s = (String) it.next();
			System.out.println(s);
		}
		for (String s : list) {
			System.out.println(s);
		}

		
	}
}
