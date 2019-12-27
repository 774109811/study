package day1501_����ת����;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Text1 {
	public static void main(String[] args) throws Exception {
		String s = "abc���Ć��F";
		System.out.println(s);
		
		//Unicodeת����������
		f(s,null);
		f(s,"GBK");
		f(s,"GB2312");
		f(s,"UTF-8");
		
		
	}
	//encoding ���� 
	//charset �ַ���
	private static void f(String s, String charset) throws Exception {
		byte[] a;
		if(charset==null){
			a=s.getBytes();
		}else{
			a=s.getBytes(charset);
		}
		System.out.println(charset+"\t"+Arrays.toString(a));
	}

}
