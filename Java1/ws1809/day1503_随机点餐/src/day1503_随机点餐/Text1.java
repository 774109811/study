package day1503_随机点餐;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Text1 {
private static List<Food>list;//建立一个Food集合的成员变量

	
	public static void main(String[] args) throws Exception {
		//首先读取文件food-list.txt生成集合，第一个封装food
		System.out.println("按回车");
		while(true){
			new Scanner(System.in).nextLine();
			list =load();//建立加载方法，保存到这个集合里
//		System.out.println(list);//打印这个集合
			
			int index =list.size()/3*2;
			//存放随机挑选的食物的数组
			Food[] a = new Food[3];
			a[0] = list.get(new Random().nextInt(index));
			//死循环选择第二个
			while(true){
				Food f = list.get(
						new Random().nextInt(index));
				//重复的选择了同一个对象
				if(f == a[0]){
					continue;
				}
				a[1]= f;
				break;
			}
			//第三个
			//index+[0,size()-index)
			a[2] = list.get(index+new Random().nextInt(list.size()-index));
			//三个食物的选择次数递增
			for(Food f:a){
				f.setTimes(f.getTimes()+1);
			}
			//list中所有事物，重写排序
			Collections.sort(list);
			//list中数据，保存到文件
			save(list);
			
			//显示选择结果
			for(Food f:a){
				System.out.println(f.getName());
			}
			
			
		}
		}

	private static void save(List<Food> list) throws Exception {
		//先获得路径
		String path =getPath();
		//PW--OSW--FOS--path,输出path路径，转化成GBK
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path),"GBK"));
		for(Food f:list){ //遍历这个文件路径输出流
			out.println(f);
		}
		out.close();//结束后关闭输出流
	}

	private static List<Food> load() throws Exception {
		String path =getPath();//获取food文件的路径
//		System.out.println(path);
		//BR-ISR--FIS--path
		List<Food> list = new ArrayList<>();//建立一个集合
		//读取这个path这个路径然后转化GBK格式
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path),"GBK"));
		String line;//定义一个变量
		while((line=in.readLine())!=null){//当读取的这个路径不是空值
			line = line.trim();//把读取的字符串前后空格清除
			if("".equals(line)){//如果一行是空的直接跳过
				continue;
			}
			String[]a =line.split(";");//从；断开字符
			Food f=new Food(a[0].trim(),Integer.parseInt(a[1].trim()));
			list.add(f);//
		}
		
		return list;
	}

	private static String getPath() throws Exception {
		/*
		 * Test1.class，存放在
		 * D:\lesson\1809\ws1809\day1503_随机点餐\bin
		 * 与Test1.class存放在一起的文件，
		 * 可以相对于bin目录来访问
		 * 
		 * "/" 程序的运行目录,bin目录
		 * "/food-list.txt"
		 * "/day1503/food-list.txt"
		 */
		//返回URL编码格式
		//中文编码成UTF-8字节值
		//%e9%9a%8f

		//返回URL编码格式
		//中文编码成UTF-8字节值                                                                      //获取food文件路径，不能写死，“/”+文件名
		String path = Text1.class.getResource("/food-list.txt").getPath();//获取food文件路径
		//URL解码回正长的中文
		path = URLDecoder.decode(path, "UTF-8");
		
		return path;
	}

}
