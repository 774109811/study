package day1404_Buffered文件合并;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("拆分文件存放目录：");
		String s1 = new Scanner(System.in).nextLine();
		File dir = new File(s1);//把s1名字存到文件夹dir
		if(! dir.isDirectory()) {//不是文件夹，直接返回
			System.out.println("不是文件夹");
			return;
		}
		
		
		System.out.println("合并的目标文件：");
		String s2 = new Scanner(System.in).nextLine();
		File to = new File(s2);//输入要合并的目标文件
		if(to.isDirectory()) {//不能是文件夹，必须是文件
			System.out.println("不能是文件夹");
			return;
		}
		
		try {
			heBing(dir, to);//创建一个方法，把to文件合并到dir文件夹里
			System.out.println("完成");
		} catch (Exception e) {
			System.out.println("失败");
			e.printStackTrace();
		}
		
		
	}

	private static void heBing(
			File dir, File to) throws Exception{
		//对dir文件夹目录列表出来然后输出建立一个方法
		File[] files = list(dir);//
		//把文件输出合并，需要先读取后输出，输出流
		FileOutputStream out = new FileOutputStream(to);
		FileInputStream in;//读取
		byte[] buff = new byte[8192];//按数组来读取
		int n;//每一批的数量
		
		//遍历文件列表
		for (File f : files) {
			in = new FileInputStream(f);//创建读取文件输入流
			while((n = in.read(buff)) != -1) {//当它不等于-1时
				out.write(buff,0,n);//写入读取的数组文件 ，从0开始到n
			}
			in.close();//读完后然后关闭读取
		}
		out.close();//最后关闭写入输出流
	}

	private static File[] list(File dir) {//对文件夹里的文件列表
		File[] files = dir.listFiles();//对dir这个文件夹别表出来保存到files
		Arrays.sort(files, new Comparator<File>() {//然后比较File末尾的.后面的数字
			@Override
			public int compare(File o1, File o2) {
				String n1 = o1.getName();//获取文件的名字
				String n2 = o2.getName();
				// xxx.xx.23 --> 23
				//substring截取字符串中的字串 .+1的下表位置                                                  
				n1 = n1.substring(n1.lastIndexOf(".")+1);
				n2 = n2.substring(n2.lastIndexOf(".")+1);
				int a = Integer.parseInt(n1);//把字符串解析成int类型
				int b = Integer.parseInt(n2);
				return a-b;			//比较大小	
			}
		});
		return files;//返回这一组文件
	}

}
