package day1401_�ļ���;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Text2 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f1");//��ȡ�ļ���
		int b;//����ø�ٶ�ȡ���ֽ�ֵ
		 while((b=in.read())!= -1){//�����ȡ��ֵ����-1
			 System.out.println(b);
		 }
		 in.close();
	}

}
