package day0504;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Text1 {

	public static void main(String[] args) {
		int[] a=suiji();
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("输入查找的目标值：");
		int t= new Scanner(System.in).nextInt();
		
		int index =binarySearch(a,t);
		if(index>=0){
			System.out.println("下标位置"+index);
		}else{
			System.out.println("目标不存在");
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
	       * *)定义三个下标变量
	       *   lo=0
	       *   hi=a.length-1
	       *   mid;
	       * *)当lo<=hi
	       *     *)mid=(lo+hi)/2
	       *     *)mid位置值比t大，hi移到mid-1位置
	       *     *)否则如果mid位置值比t小，lo移到mid+1位置          
	       *     *)否则，返回 mid 下标值
	       * 
	       * *)返回-1，无意义值，表示找不到
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
