package day06��ϰ;

import java.util.Random;

     


public class Soldier {
	
	int id;
	int blood;
	public void go(){
		int a =5+new Random().nextInt(100);
		System.out.println(id+"ʿ��ǰ��"+a+"��");
	}
	public void attack(){
		if(blood==0){
			System.out.println(id+"������������Ϣ");
			return;
		}
		System.out.println(id+"ʿ��������");
		int a =1+new Random().nextInt(10);
		blood-=a;
		if(blood<0){
			blood=0;
		}
		System.out.println(id+"Ѫ��ֵ"+blood);
		if(blood==0){
			System.out.println(id+"�Ѿ�����");
		}
	}
}
