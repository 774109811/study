package day1302_File�ļ�;

import java.io.File;

public class Text1 {
	public static void main(String[] args) {
		String path;
//		path = "C:\\jdk1.8.0_131\\release";
		path = "C:\\wamp";
//		path = "k:/sad/sad/d";
		File f = new File(path);
		System.out.println(f.exists());//�Ƿ����
		System.out.println(f.getName());//�ļ���
		System.out.println(f.getParent());//���ļ���
		System.out.println(f.getAbsolutePath());//������·��
		System.out.println(f.lastModified());//����޸�ʱ��
		System.out.println(f.length());//�ֽ��������ļ�����Ч
		System.out.println(f.isFile());//�Ƿ����ļ�
		System.out.println(f.isDirectory());//�Ƿ����ļ���
		
	}
}
