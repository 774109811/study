package day1202_ArrayList;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("�ַ�����");
		String s = new Scanner(System.in).nextLine();
		System.out.println("���ҵ��Ӵ���");
		String t = new Scanner(System.in).nextLine();
//		��s�е�t�ַ�����һ���������浽����
		ArrayList<Integer> list = find(s,t);
//		Iterator<Integer>  it = list.iterator();
//		�������ҵ��ļ��ϣ��õ���������
		for(Iterator<Integer> it = list.iterator();it.hasNext();){
			Integer i = it.next();
			System.out.println(i);
//		
//		while(it.hasNext()){
//			Integer i = it.next();
//			System.out.println(i);
		}
		
	}
//	��s�е�t�ַ�����һ���������浽����
	private static ArrayList<Integer> find(String s, String t) {
//		����һ���±�λ��
		int from = 0;
//		�õ�����������������ַ�
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true){
//			��s�ַ��в��� t�ַ����±�from�����浽from
			from = s.indexOf(t,from);
//			from����ֱ������
			if(from == -1){
				break;
			}
			
			list.add(from);
			from++;
		}
		return list;
	}
}
