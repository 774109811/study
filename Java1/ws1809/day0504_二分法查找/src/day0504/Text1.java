package day0504;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Text1 {

	public static void main(String[] args) {
		int[] a=suiji();
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("������ҵ�Ŀ��ֵ��");
		int t= new Scanner(System.in).nextInt();
		
		int index =binarySearch(a,t);
		if(index>=0){
			System.out.println("�±�λ��"+index);
		}else{
			System.out.println("Ŀ�겻����");
		}

	}

	private static int[] suiji() {
		int n=5+new Random().nextInt(6);
		int [] a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		return a;
	}

	private static int binarySearch(int[] a, int t) {
		/*
	       * t = 70
	       * a
	       *                  mid
	       * [23, 55, 64, 69, 70, 71, 75, 89, 92]
	       *  lo
	       *                                  hi
	       * *)���������±����
	       *   lo=0
	       *   hi=a.length-1
	       *   mid;
	       * *)��lo<=hi
	       *     *)mid=(lo+hi)/2
	       *     *)midλ��ֵ��t��hi�Ƶ�mid-1λ��
	       *     *)�������midλ��ֵ��tС��lo�Ƶ�mid+1λ��          
	       *     *)���򣬷��� mid �±�ֵ
	       * 
	       * *)����-1��������ֵ����ʾ�Ҳ���
	       */
		 int lo=0;
		int hi=a.length-1;
		int mid;
		while(lo<=hi){
			mid=(lo+hi)/2;
			if(a[mid]>t){
				hi=mid-1;
			}else if(a[mid]<t){
				lo=mid+1;
			}else{
				return mid;
			}
		}
		return 0;
	}

}
