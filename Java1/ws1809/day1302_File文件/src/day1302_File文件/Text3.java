package day1302_File�ļ�;

import java.io.File;
import java.util.Scanner;

public class Text3 {
	public static void main(String[] args) {
		System.out.println("�����ļ���");
		String s= new Scanner(System.in).nextLine();
		File dir = new File(s);//�½��ļ�	
		if(!dir.isDirectory()){//��������ļ�
		System.out.println("����Ĳ����ļ���");
		return;
		}
		String[] names = dir.list();//�õ��ļ�����������
		File[] files = dir.listFiles();//�õ��ļ��к��ļ�����
		if(names == null){
			System.out.println("�޷�����б�");
			return;
		}
		for(String n : names){
			System.out.println(n);
		}
	
		System.out.println("\n--------------");
		
		for(File f:files ){
			System.out.println(f.getName()+"-"+f.length()+f);;
		}
	}
}
