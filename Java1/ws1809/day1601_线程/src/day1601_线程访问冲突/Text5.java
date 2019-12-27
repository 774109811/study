package day1601_线程访问冲突;
import java.util.Arrays;
import java.util.Scanner;

public class Text5 {
	static char[]a={'-','-','-','-','-',};
	static char c = '*';
	public static void main(String[] args) {
		//new Thread(){}.start();
		new Thread(){//匿名继承类
			public void run() {//建run方法
				while(true){
					synchronized (a) {//用数组a加锁
						for (int i = 0; i < a.length; i++) {
							a[i]=c;
						}		
					}
					c = c=='*'?'-':'*';
//					System.out.println(Arrays.toString(a));
				}  		
			};
		}.start();
		new Thread(){
			public void run() {
				while(true){
					synchronized (a) {
						System.out.println(Arrays.toString(a));
					}
				}	
			};
		}.start();
	}

}
