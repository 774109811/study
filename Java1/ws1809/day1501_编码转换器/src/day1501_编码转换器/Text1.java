package day1501_编码转换器;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Text1 {
	public static void main(String[] args) throws Exception {
		String s = "abc中文喆镕";
		System.out.println(s);
		
		//Unicode转成其他编码
		f(s,null);
		f(s,"GBK");
		f(s,"GB2312");
		f(s,"UTF-8");
		
		
	}
	//encoding 编码 
	//charset 字符集
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
