package day1304_删除文件夹;

import java.io.File;
import java.util.Scanner;

public class Next1 {
	public static void main(String[] args) {
		System.out.println("输入要删除的文件夹（不可恢复）：");
		String s= new Scanner(System.in).nextLine();
		File dir = new File(s);
		if(!dir.isDirectory()){
			System.out.println("输入的不是文件夹");
			return;
		}
		
		boolean b = deleteDir(dir);
		if(b){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	private static boolean deleteDir(File dir) {
		File[] files = dir.listFiles();//把文件个文件夹放到数组里
		if(files==null ){//如果他是空的
			return dir.delete();//列表列不出来尝试删除目录
		}
		for(File f:files){//遍历它产出子文件和子文件夹
			if(f.isFile()){//如果他是文件
				if(!f.delete()){//如果没有删除文件
					return false;//返回错误
				}
			}
		else{
			if(!deleteDir(f)){//如果是文件
				return false;
			}
		}	
	}
		return dir.delete();//删除dir文件夹
	}
}
