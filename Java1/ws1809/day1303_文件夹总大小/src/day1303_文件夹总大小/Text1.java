package day1303_�ļ����ܴ�С;

import java.io.File;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("�ļ���");
		String s= new Scanner(System.in).nextLine();
		File dir = new File(s);//�����ļ���������s�ַ�
		if(!dir.isDirectory()){//����ļ��в�����
			System.out.println("����Ĳ����ļ���");
			return;
		}
		long size = dirlength(dir);//�ļ����ֽڳ���
		System.out.println(size);
		
		
	}

	private static long dirlength(File dir) {
		 File[] files = dir.listFiles();//�����ļ��к��ļ����浽������
		 if(files==null){//�������ļ����ļ����ǿ�ֵ�򷵻�0
			 return 0;
		 }
		 long sum=0;//����һ���ļ���������
		 for(File f : files){//��������ַ�
			 if(f.isFile()){//������ļ�
				 sum+=f.length();//�ļ����ֽ�+����sum���浽sum
			 }else{//�������ļ���
				 sum+=dirlength(f);
			 }
		 }
		 return sum;
	}
}
