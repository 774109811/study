package day1504_作业目录总大小;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("文件夹");
		String s= new Scanner(System.in).nextLine();
		File dir = new File(s);//输入文件夹名字是s字符
		if(!dir.isDirectory()){//如果文件夹不存在
			System.out.println("输入的不是文件夹");
			return;
		}
		long size = dirlength(dir);//文件的字节长度
		System.out.println(size);
	}

	private static long dirlength(File dir) {
		//双向链表新建L
		LinkedList<File> list = new LinkedList<>();
		//初始状态dir添加到list
		list.add(dir);
		//文件大小累加变量
		long sum =0;
		//当集合不是空集合
		while(list.size()!=0){
			File f = list.removeFirst();
			if(f.isFile()){
				sum+=f.length();
			}else{//f是文件夹,展开列表，全部加入list头部
				File[] files = f.listFiles();
				for(File f2:files){
					list.addFirst(f2);
				}
				
			}
		}
		return sum;
		
	}

}
