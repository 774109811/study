package day1203;

import java.util.HashMap;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("输入字符串：");
		String s = new Scanner(System.in).nextLine();
		//新建HashMap
		HashMap<Character, Integer> map = new HashMap<>();
		//遍历字符串s
		for(int i =0;i<s.length();i++){
			//取出i位置字符
			char c = s.charAt(i);
			//从map获取c对应的计数值
	       Integer count = map.get(c);
           // 如果count是null没有这个字母就是放入1个
	       if(count == null){
	    	   map.put(c,1);
	       }else{
//	    	   如果有的话就加一个
	    	   map.put(c,count+1);
	       }
	    }
//		打印map的键和
	    System.out.println(map);
	}
}
