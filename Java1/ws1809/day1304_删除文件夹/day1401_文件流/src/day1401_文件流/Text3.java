package day1401_�ļ���;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Text3 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f1");//��ȡ�ļ���
		byte[]buff = new byte[5];//�½�һ������
		int n;//����һ�������Ѷ�ȡ�����ݵķ���ֵ���浽����n
		while((n=in.read(buff))!=-1){//����ȡ�����ݲ�����-1ʱ��ӡ�����������
			System.out.println(n+"-"+Arrays.toString(buff));
		}
		in.close();// �ͷ�ϵͳ��Դ,�رպ��ܶ�ȡ
		
	}
}
