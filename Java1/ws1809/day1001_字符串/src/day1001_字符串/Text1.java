package day1001_�ַ���;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("email:");
		String e = new Scanner(System.in).nextLine();
		String name = getname(e);
		System.out.println(name);
	}

	private static String getname(String e) {
//		����e�ַ�����ȥ�����˿հ��ַ����ڴ浽����e 
		e = e.trim();
//		��e�в����ַ�����@�����±�λ�ô浽 index��
		int index = e.indexOf("@");
//		���@�����ڣ����ظ�ʽ����
		if(index == -1){
			System.out.println("��ʽ����");
		}
//		��ȡ
		e= e.substring(0,index);
		return e;
		
	}
}
