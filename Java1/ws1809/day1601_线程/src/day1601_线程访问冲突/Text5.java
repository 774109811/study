package day1601_�̷߳��ʳ�ͻ;
import java.util.Arrays;
import java.util.Scanner;

public class Text5 {
	static char[]a={'-','-','-','-','-',};
	static char c = '*';
	public static void main(String[] args) {
		//new Thread(){}.start();
		new Thread(){//�����̳���
			public void run() {//��run����
				while(true){
					synchronized (a) {//������a����
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
