package day1104_��ʽ����;

import java.util.NoSuchElementException;
import java.util.Scanner;

import day1104_��ʽ����.Formula.DieDaiQi;



public class Text1 {
	public static void main(String[] args) {
		while(true){
		System.out.println("������ʽ��");
		String s = new Scanner(System.in).nextLine();
		Formula f = new Formula(s);
		DieDaiQi it = f.iterator();
		//��ֵ
		try {
			while(it.hasNext()){
				String b = it.next();
				System.out.println(b);
			}	
		 double r = f.eval();
		 System.out.println(r);
		  break;
		}catch(IllegalStateException e){
			System.out.println("��������ȷ�ĸ�ʽ(12+13-45*15/16)");
		}
		 catch (NoSuchElementException e) {
			System.out.println("������ȷ�ĸ�ʽ(12+13-45*15/16)");
		 }catch(IndexOutOfBoundsException E){
			 System.out.println("�����룺");
		 }
		
		finally{
			System.out.println("\n----------");
		}
	}
	
	}
}
