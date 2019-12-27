package day1401_文件流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Text2 {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f1");//读取文件流
		int b;//保存酶促读取的字节值
		 while((b=in.read())!= -1){//如果读取的值等于-1
			 System.out.println(b);
		 }
		 in.close();
	}

}
