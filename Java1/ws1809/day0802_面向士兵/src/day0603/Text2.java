package day0603;

import java.util.Scanner;

public class Text2 {
//	�½�������
public static void main(String[] args) {
	Soldier []a=new Soldier[5];
//		��������
		for(int i=0;i<a.length;i++){
//			�½����󱣴浽����
			a[i]=new Soldier();
//			����iλ�õ�ID
			a[i].id=i+1;
		}
		System.out.println("�Ѵ���5��ʿ��");
		System.out.println("�س�����");
//		�����д����ʿ��
		while(Soldier.count !=0){
			 new Scanner(System.in).nextLine();
			System.out.println("\n--------");
			for(int i=0;i<a.length;i++){
			a[i].attack();}
			System.out.println("ʿ������"+Soldier.count);
			System.out.println("\n--------");
		}
}
}