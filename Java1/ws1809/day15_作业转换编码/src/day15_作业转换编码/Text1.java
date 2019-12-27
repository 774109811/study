package day15_��ҵת������;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("����ԭ�ļ���GBK����");
		String s1= new Scanner(System.in).nextLine();
		 File from = new File(s1);
		if(!from.isFile()){
			System.out.println("�������ļ�");
			return;
		}
		System.out.println("����ת��Ŀ���ļ���UTF-8��");
		String s2= new Scanner(System.in).nextLine();
		File to = new File(s2);
		if(to.isDirectory()){
			System.out.println("�������ļ���");
			return;
		}
		try {
			zhuanma(from,to);
			System.out.println("�ɹ�");
		} catch (Exception e) {
			System.out.println("ʧ��");
			e.printStackTrace();
		}
		
	}

	private static void zhuanma(File from, File to) throws Exception {
		InputStreamReader in = new InputStreamReader(new FileInputStream(from),"GBK");

		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(to),"UTF-8");
		int n;
		while((n=in.read())!=-1){
			out.write(n);
		}
		in.close();
		out.close();
	}

}
