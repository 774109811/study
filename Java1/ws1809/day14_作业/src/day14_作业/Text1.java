package day14_��ҵ;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("����ԭ�ļ��ļ�");
		String s1= new Scanner(System.in).nextLine();
		File from = new File(s1);
		if(!from.isFile()){
			System.out.println("�����ļ�������д����");
			return;
		}
		System.out.println("Ŀ���ļ�");
		String s2= new Scanner(System.in).nextLine();
			File to = new File(s2);
			if(to.isDirectory()){
				System.out.println("���ļ��У��������ļ�");
				return;
			}
		try {
			copy(from,to);
			System.out.println("���");
		} catch (Exception e) {
			System.out.println("ʧ��");
			e.printStackTrace();
		}
	}

	private static void copy(File from, File to) throws Exception {
		FileInputStream in = new FileInputStream(from);
		 BufferedInputStream IN = new BufferedInputStream(in);
		FileOutputStream out = new FileOutputStream(to);
		BufferedOutputStream OUT = new BufferedOutputStream(out);
//		byte[]a = new byte[8192];
		int b;
		while((b=IN.read())!=-1){
			OUT.write(b);
		}
		IN.close();
		OUT.close();
		
		
	}

}
