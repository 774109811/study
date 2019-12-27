package day1302_File文件;

import java.io.File;

public class Text1 {
	public static void main(String[] args) {
		String path;
//		path = "C:\\jdk1.8.0_131\\release";
		path = "C:\\wamp";
//		path = "k:/sad/sad/d";
		File f = new File(path);
		System.out.println(f.exists());//是否存在
		System.out.println(f.getName());//文件名
		System.out.println(f.getParent());//父文件名
		System.out.println(f.getAbsolutePath());//完整的路径
		System.out.println(f.lastModified());//最后修改时间
		System.out.println(f.length());//字节量，对文件夹无效
		System.out.println(f.isFile());//是否是文件
		System.out.println(f.isDirectory());//是否是文件夹
		
	}
}
