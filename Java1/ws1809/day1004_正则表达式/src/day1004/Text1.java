package day1004;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("���֤�ţ�");
		String id= new Scanner(System.in).nextLine();
		System.out.println("�̶��绰���룺");
		String tel= new Scanner(System.in).nextLine();
		if(f1(id)){
			System.out.println("���֤�Ÿ�ʽ��ȷ");
		}else{
			System.out.println("���֤�Ÿ�ʽ����");
		}
		if(f2(tel)){
			System.out.println("�绰�����ʽ��ȷ");
		}else{
			System.out.println("�绰�����ʽ����");
		}
	}

	private static boolean f1(String id) {
		String regex ="\\d{15}|\\d{17}[\\dxX]";
//		ƥ��
		return id.matches(regex);
	}

	private static boolean f2(String tel) {
		String regex="(\\d{3,4}-|\\(\\d{3,4}\\))?\\d{7,8}";
		
		return tel.matches(regex);
	}
}
