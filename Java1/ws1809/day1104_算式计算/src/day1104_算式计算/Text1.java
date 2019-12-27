package day1104_算式计算;

import java.util.NoSuchElementException;
import java.util.Scanner;

import day1104_算式计算.Formula.DieDaiQi;



public class Text1 {
	public static void main(String[] args) {
		while(true){
		System.out.println("输入算式：");
		String s = new Scanner(System.in).nextLine();
		Formula f = new Formula(s);
		DieDaiQi it = f.iterator();
		//求值
		try {
			while(it.hasNext()){
				String b = it.next();
				System.out.println(b);
			}	
		 double r = f.eval();
		 System.out.println(r);
		  break;
		}catch(IllegalStateException e){
			System.out.println("请输入正确的格式(12+13-45*15/16)");
		}
		 catch (NoSuchElementException e) {
			System.out.println("请输正确的格式(12+13-45*15/16)");
		 }catch(IndexOutOfBoundsException E){
			 System.out.println("请输入：");
		 }
		
		finally{
			System.out.println("\n----------");
		}
	}
	
	}
}
