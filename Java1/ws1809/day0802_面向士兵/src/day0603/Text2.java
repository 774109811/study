package day0603;

import java.util.Scanner;

public class Text2 {
//	新建数组存放
public static void main(String[] args) {
	Soldier []a=new Soldier[5];
//		遍历数组
		for(int i=0;i<a.length;i++){
//			新建对象保存到数组
			a[i]=new Soldier();
//			访问i位置的ID
			a[i].id=i+1;
		}
		System.out.println("已创建5个士兵");
		System.out.println("回车继续");
//		当还有存货的士兵
		while(Soldier.count !=0){
			 new Scanner(System.in).nextLine();
			System.out.println("\n--------");
			for(int i=0;i<a.length;i++){
			a[i].attack();}
			System.out.println("士兵数量"+Soldier.count);
			System.out.println("\n--------");
		}
}
}