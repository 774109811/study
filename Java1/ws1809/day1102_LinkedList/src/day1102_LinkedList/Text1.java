package day1102_LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Text1 {
	public static void main(String[] args) {
//		
//		不支持基本类型 ，集合用包装类；
		LinkedList<String> list =new LinkedList<>();
		list.add("aaa");
		list.add("www");
		list.add("uuu");
		list.add("kkk");
		list.add("fff");
		list.add("aaa");
		list.add("aaa");
		int a=list.size();
		System.out.println(a);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(list.size()-1));
		System.out.println(list.remove(2));
		System.out.println(list);
		System.out.println(list.remove("aaa"));
		System.out.println(list);
		
		for(int i=0;i<list.size();i++){
			String s = list.get(i);
			System.out.println(s);
		}
//		迭代器遍历
//		新建迭代器对象 保存到It
//		数据类型是String类型
		Iterator<String> it = list.iterator();
//		判断当 it hasnext还有下一个数据，就调用it.next
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
	}
}
