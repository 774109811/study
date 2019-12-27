package day1202_练习;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("需要多少士兵：");
		int n =new Scanner(System.in).nextInt();
		 ArrayList<Soldier> list = new ArrayList<>(n);
		for(int i =1;i<n;i++){
			 Soldier s = new Soldier();
			 s.id =i;
			 list.add(s);
		}
			new Scanner(System.in).nextLine();
			while(list.size()!=0){
			Iterator<Soldier> it = list.iterator();
				while(it.hasNext()){
				Soldier s  =it.next();
				s.attack();	
				if(s.blood == 0){
					it.remove();
					
				}
			}
				
			System.out.println("士兵数量"+list.size());
			;
			System.out.println("\n----------");
			
		}
		 
	}
}
