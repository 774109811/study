package day0801;

import java.util.Random;
import java.util.Scanner;

public class GuessLetterGame extends GuessGame {

	@Override
	public String suiji() {
//		�½�StringBuilder�������26����ĸ��
		StringBuilder sb= new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//		ѭ������ǰ5��λ��
		for(int i =0;i<5;i++){
//			26��λ���������λ
			int j =new Random().nextInt(26);
//			����λ�ò���ֵ��set
			char t =sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, t);
		}
		sb.delete(5,26);
		return sb.toString();
	}
	@Override
	public void tishi() {
		System.out.println("�Ѿ����������5�����ظ��Ĵ�д��ĸ");
		System.out.println("�����5����ĸ");
	}
	@Override
	public String bijiao(String c, String r) {
//		�Դ�����a��b
		int a=0;
		int b=0;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if( c.charAt(i)==r.charAt(j)){
					if(i==j) a++;
					else b++ ;
					break;
				}
			}
		}
		return a+"A"+b+"B";
	}
	@Override
	public boolean caiDui(String result) {
		return "5A0B".equals(result);
	}
	
}
