package day11_¡∑œ∞À„∑®;

import java.util.Scanner;

import day11_¡∑œ∞À„∑®.Formula.DieDaiQi;

public class Text1 {
	public static void main(String[] args) {
		System.out.println(" ‰»ÎÀ„ Ω£∫");
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
