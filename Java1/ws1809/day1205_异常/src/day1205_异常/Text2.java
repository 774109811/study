package day1205_异常;

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
			System.out.println("日期格式错误");
			// 打印完整的异常信息
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("目录不存在");
			e.printStackTrace();
		}
	}

	private static void f1() throws ParseException,IOException{
		System.out.println("生日（yyyy-MM-dd):");
		String s= new Scanner(System.in).nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(s);
//		获取这个时间保存到d盘的路径
		String path ="d:\\"+d.getTime()+".http";
//		把这个路径放到文档当中
		File f =new File(path);
//		f调用这个创建新的文档方法
		f.createNewFile();
	} 
}
