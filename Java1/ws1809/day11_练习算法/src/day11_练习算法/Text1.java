package day11_��ϰ�㷨;

import java.util.Scanner;

import day11_��ϰ�㷨.Formula.DieDaiQi;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("������ʽ��");
		String s = new Scanner(System.in).nextLine();
		Formula f = new Formula(s);
		DieDaiQi it = f.iterator();
		while(it.hasNext()){
			String b=it.next();
			System.out.println(b);
		}
		double r = f.eval();
		System.out.println(r);
	}
}
