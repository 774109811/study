package day1401_文件流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Text3 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f1");//读取文件流
		byte[]buff = new byte[5];//新建一个数组
		int n;//定义一个变量把读取的数据的返回值保存到变量n
		while((n=in.read(buff))!=-1){//当读取的数据不等于-1时打印出来这个数组
			System.out.println(n+"-"+Arrays.toString(buff));
		}
		in.close();// 释放系统资源,关闭后不能读取
		
	}
}
