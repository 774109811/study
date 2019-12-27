package day1001_字符串;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("email:");
		String e = new Scanner(System.in).nextLine();
		String name = getname(e);
		System.out.println(name);
	}

	private static String getname(String e) {
//		参数e字符串中去除两端空白字符，在存到变量e 
		e = e.trim();
//		在e中查找字符串“@”，下标位置存到 index；
		int index = e.indexOf("@");
//		如果@不存在，返回格式错误
		if(index == -1){
			System.out.println("格式错误");
		}
//		截取
		e= e.substring(0,index);
		return e;
		
	}
}
