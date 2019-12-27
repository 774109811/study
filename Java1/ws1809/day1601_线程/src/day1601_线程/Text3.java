package day1601_线程;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Text3 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
		//main线程
		System.out.println("按回车捅醒T1线程");
		 new Scanner(System.in).nextLine();
		t1.interrupt();
	}
	static class T1 extends Thread{
		long t;//用来保存第一次的毫秒值
		@Override
		public void run() {
			while(true){
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
			Date d = new Date();
			int y =0;//对1000的余数
			if(t==0){//第一次打印
				t= d.getTime();
			}else{//在次打印
				y=(int)((d.getTime()-t)%1000);
			}
			String s = sdf.format(d);
			System.out.println(s);
			try {
				Thread.sleep(1000-y)   ;
			} catch (InterruptedException e) {	
				System.out.println("谁整醒的老子");
				break;
			}			
			}
			
			
		}
		
		
	}

}
