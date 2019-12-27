package day1302_File文件;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) throws IOException {
		System.out.println("按回车");
		 new Scanner(System.in).nextLine();
		File dir = new File("d:/abc/aa");
		dir.mkdirs();//新建文件夹
		new Scanner(System.in).nextLine();
		 File f = new File("d:/abc/aa/a.txt");
		 f.createNewFile();//新建文件
		new Scanner(System.in).nextLine();
		f.delete();//删除文件
		new Scanner(System.in).nextLine();
		dir.delete();//删除文件夹
		
	    new Scanner(System.in).nextLine();
	    File die = new File("d:/asdasd/asd");
	    die.mkdirs();//新建文件夹
	    f.delete();//删除文件
	    die.delete();//删除文件夹
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
}
