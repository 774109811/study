package day1205_�쳣;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		try {
			f1();
		} catch (ParseException e) {
			System.out.println("���ڸ�ʽ����");
			// ��ӡ�������쳣��Ϣ
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ŀ¼������");
			e.printStackTrace();
		}
	}

	private static void f1() throws ParseException,IOException{
		System.out.println("���գ�yyyy-MM-dd):");
		String s= new Scanner(System.in).nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(s);
//		��ȡ���ʱ�䱣�浽d�̵�·��
		String path ="d:\\"+d.getTime()+".http";
//		�����·���ŵ��ĵ�����
		File f =new File(path);
//		f������������µ��ĵ�����
		f.createNewFile();
	} 
}
