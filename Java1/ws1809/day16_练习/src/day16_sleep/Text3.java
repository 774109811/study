package day16_sleep;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Text3 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
		System.out.println("按回车打断");
		 new Scanner(System.in).nextLine();
		 t1.interrupt();
	}
	static class T1 extends Thread{
		long t;//保存第一次的毫秒值
		@Override
		public void run() {
		SimpleDateFormat sdf = new	SimpleDateFormat("HH:mm:ss:SSS");
		
		while(true){
			Date d = new Date();//新建Date
			int y =0;//1000的余数
			if(t==0){//第一次打印的时间
				t = d.getTime();
			}else{//再次打印
				y= (int)(d.getTime()-t)%1000;//
			}
		String s=sdf.format(d);//解析成字符串
			System.out.println(s);
			try {
				Thread.sleep(1000-y);//暂停等待秒
			} catch (InterruptedException e) {
				System.out.println("谁打断的");
				break;
			}
		
		}
		
			
		}
		
	}
}
