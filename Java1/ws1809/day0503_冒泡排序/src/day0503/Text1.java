package day0503;

import java.util.Arrays;
import java.util.Random;

public class Text1 {
	public static void main(String[] args) {
		int[] a=suiji();//����һ�������������
		System.out.println(Arrays.toString(a));
		System.out.println("----------");
		sort(a); //������a���򷽷�a
		System.out.println("----------");
		System.out.println(Arrays.toString(a));
	}

	private static int[] suiji() {
		//����һ���������ֵ�浽����n
	      //��Χ 5 + [0, 6)
		int n =5+new Random().nextInt(8);
		//�½� int[] ���飬���� n
	      //��ַ�浽���� a
		int []a=new int[n];
		 //��������100���������
		for(int i=1 ;i<a.length;i++){
			a[i]=new Random().nextInt(100);
			
		}
		//�������� a
		return a;
	}

	private static void sort(int[] a) {
	     /*
	       *                       j
	       * [14, 20, 37, 69, 53, 51]
	       *              i
	       * 
	       * jѭ���Ӻ���ǰ�ݼ����ѽ�Сֵ��ǰ������
	       * ֱ������Сֵ�Ƶ�iλ��Ϊֹ
	       * 
	       *                 
	       * [3, 12, 15, 32, 52, 52, 65]
	       *             i
	       * 
	       *          jѭ����ʼ֮ǰ
	       *          boolean flag = false û�н���
	       *                  //falg = true  ����������
	       * 
	       *          if(!flag) {
	       *            break;
	       *          }	       
	       */
		for(int i=0;i<a.length;i++){
			boolean flag =false;//û�н��� 
			//jѭ������Сֵ�Ƶ�iλ��
			for(int j=a.length-1;j>i;j--){
				if((a[j]<a[j-1])){
					int t=a[j];
					a[j]=a[j-1];
					a[j-1]=t;
					flag=true;
				}
			}
			//flag��false,û�н������ݣ���������λ�ö���ȷ
			if( flag ==false){
				break;
			}
			System.out.println(Arrays.toString(a));
		}
	}
}
