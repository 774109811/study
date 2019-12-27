package day1401_文件流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Text1 {
	public static void main(String[] args) throws Exception {
		
		FileOutputStream out = new FileOutputStream("d:/abc/f1");//文件输出流
		out.write(97);// 00 00 00 61 --61
		out.write(98);// 00 00 00 62 --62
		out.write(99);// 00 00 00 63 --63
		out.write(356);// 00 00 00 64 --64
		
		byte []a={
				101,102,103,104,105,
				106,107,108,109,110};
		out.write(a);// 输出数组中全部10个字节
		out.write(a,3,4);// 输出数组中冲下表3开始的4个字节
		out.close();// 释放系统资源,关闭后不能输出了
}	
}

