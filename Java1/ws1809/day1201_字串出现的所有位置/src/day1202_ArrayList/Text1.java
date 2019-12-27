package day1202_ArrayList;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("字符串：");
		String s = new Scanner(System.in).nextLine();
		System.out.println("查找的子串：");
		String t = new Scanner(System.in).nextLine();
//		在s中的t字符创建一个方法保存到集合
		ArrayList<Integer> list = find(s,t);
//		Iterator<Integer>  it = list.iterator();
//		遍历查找到的集合，用迭代器遍历
		for(Iterator<Integer> it = list.iterator();it.hasNext();){
			Integer i = it.next();
			System.out.println(i);
//		
//		while(it.hasNext()){
//			Integer i = it.next();
//			System.out.println(i);
		}
		
	}
//	在s中的t字符创建一个方法保存到集合
	private static ArrayList<Integer> find(String s, String t) {
//		定义一个下标位置
		int from = 0;
//		用迭代器遍历查找这个字符
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true){
//			从s字符中查找 t字符的下表from，保存到from
			from = s.indexOf(t,from);
//			from超出直接跳出
			if(from == -1){
				break;
			}
			
			list.add(from);
			from++;
		}
		return list;
	}
}
