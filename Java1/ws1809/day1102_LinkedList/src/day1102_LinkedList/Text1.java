package day1102_LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Text1 {
	public static void main(String[] args) {
//		
//		��֧�ֻ������� �������ð�װ�ࣻ
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
//		����������
//		�½����������� ���浽It
//		����������String����
		Iterator<String> it = list.iterator();
//		�жϵ� it hasnext������һ�����ݣ��͵���it.next
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
	}
}
