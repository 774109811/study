package day06练习;

import java.util.Random;

     


public class Soldier {
	
	int id;
	int blood;
	public void go(){
		int a =5+new Random().nextInt(100);
		System.out.println(id+"士兵前进"+a+"米");
	}
	public void attack(){
		if(blood==0){
			System.out.println(id+"他已阵亡，安息");
			return;
		}
		System.out.println(id+"士兵被攻击");
		int a =1+new Random().nextInt(10);
		blood-=a;
		if(blood<0){
			blood=0;
		}
		System.out.println(id+"血量值"+blood);
		if(blood==0){
			System.out.println(id+"友军阵亡");
		}
	}
}
