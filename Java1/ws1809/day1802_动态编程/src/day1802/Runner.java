package day1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.activation.URLDataSource;

//运行器配置文件
//
public class Runner {
	private static   List<String> list  = new ArrayList<String>();
	static {
		
		try {
			//这个runner类读取这个文件，然后再获得它的路径
			String path = Runner.class.getResource("/config.txt").getPath();
			//如果有中文，然后用URLDecoder.decode(path（路径）,（字节码）"UTF-8");解析这个路径
			path =URLDecoder.decode(path,"UTF-8");
			//读取这个路径一行一行的读+然后用字符编码转换流转换成GBK，+文件流读取这个路径
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path),"GBK"));
			
			
			String line;
			while((line=in.readLine() )!=null) {
				line = line.trim();
				if(line.length()==0) {
					continue;
				}
				list.add(line);//读取的文件放入这个数组里
			}
			System.out.println(list);//打印这个数组
			in.close();//关闭读取
		} catch (Exception e) {
			System.out.println("加载配置文件config,txt 失败");
			e.printStackTrace();
		}
		
	}
	
	public static void launch() throws Exception {//启动，发动，发射
		for(String  s: list){
			String [] a= s.split(";"); //分割字符串
			Class<?> c = Class.forName(a[0].trim());//获取类
			
			Object obj = c.newInstance();//类调用无参构造
			
			Method m = c.getMethod(a[1].trim());//获取它的方法
			//方法调用
			m.invoke(obj);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println("---------------");
	}
}
