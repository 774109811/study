package day1103_����;

import java.util.LinkedList;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("��ڼ���������");
		int n =new Scanner(System.in).nextInt();
		long r =f(n);
		System.out.println(r);
		
	}

	private static long f(int n) {
		LinkedList<Long> list2 = new LinkedList<>(); 
		LinkedList<Long> list3 = new LinkedList<>(); 
		LinkedList<Long> list5 = new LinkedList<>();
		list2.add(2L);
		list3.add(3L);
		list5.add(5L);
		long r =0;//��Сֵ������
		for(int i =1;i<=n;i++){
			//ȡ��Сֵ
			long a=list2.getFirst();
			long b=list3.getFirst();
			long c=list5.getFirst();
			r = Math.min(a, Math.min(b, c));
			//�Ƴ���Сֵ
			if(r==a)list2.removeFirst();
			if(r==b)list3.removeFirst();
			if(r==c)list5.removeFirst();
			//�ڰ���Сֵ�ֱ�*235���뼯��
			list2.add(r*2);
			list3.add(r*3);
			list5.add(r*5);
		}
		return r;
	}
}
