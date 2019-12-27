package day1101_生日;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) throws ParseException {
		   System.out.println("请输入生日(yyyy-MM-dd):");
		   String r = new Scanner(System.in).nextLine();
		   SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		   //字符串r 解析成Date 对象
		   Date a = sdf.parse(r);
		   //当前时间减去自己输入的时间
		   long t =System.currentTimeMillis()-a.getTime();
		   t= t/1000/60/60/24;
		   System.out.println("您已经生存了"+t+"天");
		   Date d = new Date(10000L );   
		   System.out.println(d.getTime());
	}
}
