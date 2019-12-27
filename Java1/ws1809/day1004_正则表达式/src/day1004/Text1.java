package day1004;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("身份证号：");
		String id= new Scanner(System.in).nextLine();
		System.out.println("固定电话号码：");
		String tel= new Scanner(System.in).nextLine();
		if(f1(id)){
			System.out.println("身份证号格式正确");
		}else{
			System.out.println("身份证号格式错误");
		}
		if(f2(tel)){
			System.out.println("电话号码格式正确");
		}else{
			System.out.println("电话号码格式错误");
		}
	}

	private static boolean f1(String id) {
		String regex ="\\d{15}|\\d{17}[\\dxX]";
//		匹配
		return id.matches(regex);
	}

	private static boolean f2(String tel) {
		String regex="(\\d{3,4}-|\\(\\d{3,4}\\))?\\d{7,8}";
		
		return tel.matches(regex);
	}
}
