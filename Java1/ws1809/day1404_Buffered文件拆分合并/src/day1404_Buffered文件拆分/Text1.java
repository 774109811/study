package day1404_Buffered文件拆分;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.stream.FileImageOutputStream;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("输入要拆分的文件：");
		String s1= new Scanner(System.in).nextLine();
		 File from = new File("D:/abc/IMG_0076.JPG");//新建文件文件名位S1
		if(!from.isFile()){//如果不是文件直接返回
			System.out.println("不是文件");
			return;
		}
		 System.out.println("拆分文件的大小（kb）:");
		 long size= new Scanner(System.in).nextLong();//文件的大小
		size*=1024;//kb---byte 大小转成字节单位
		
		try {
			split(from,size);//要拆分的文件，和拆分后的大小，建立一个方法
			System.out.println("完成");
		} catch (Exception e) {
			System.out.println("失败");
			e.printStackTrace();
		}
	}

	private static void split(File from, long size) throws Exception {
		//准备文件夹
		File dir=zbwjj(from);//准备一个文件夹，建立一个方法，保存到dir
		//先获得原文件名
		String name=from.getName();
		
		long byteCount=0;//字节计数
		int fileCount=0;//文件计数
		FileInputStream in = new FileInputStream(from);//文件输入流
		FileOutputStream out =null;//文件输出流
		int b;
		while((b=in.read())!=-1){//当不等于-1输出b
			//没有输出流时候需要创建或者文件存满需要创建输出流
			if(out==null||byteCount==size){//如果输出位空或者输出的字节等于输入的字节
				if(byteCount==size){//输出的字节等于输入的字节
					out.close();//关闭前一个流 
				}
				out = new FileOutputStream(new File(dir,name+"."+(++fileCount)));
				byteCount=0;//重写开始计//文件夹里的文件名new File（文件夹，文件名）
			//输出流，新建的文件名文件计数
			}
			out.write(b);//输出b
			byteCount++;//字节增加
		}
		in.close();
		out.close();
		
	}

	private static File zbwjj(File from) {
		File dir = new File(from.getAbsoluteFile()+"_split");//获得的路径后缀名夹_split
		if(!dir.exists()){//如果这个路径不存在
			dir.mkdir();//新建一个文件夹
		}else{//否则清除这文件建立一个清除的方法
			clean(dir);
		}
		return dir;
	}

	private static void clean(File dir) {
		
		File[] files = dir.listFiles();//得到文件对象数组files
		for(File f:files){//遍历这个数组
			if(f.isFile()){//如果是文件
				f.delete();//删除文件f
			}else{ 
				clean(f);//清空文件夹里的文件f
				f.delete();//删除文件夹f
			}
		}
		
	}

}
