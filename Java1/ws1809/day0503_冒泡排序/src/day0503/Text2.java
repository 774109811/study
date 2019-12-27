package day0503;

import java.util.Arrays;
import java.util.Random;

public class Text2 {
	public static void main(String[] args) {
		int[] a=sjzs();
		System.out.println(Arrays.toString(a));
		System.out.println("\n--------");
		f(a);
		System.out.println(Arrays.toString(a));
		System.out.println("\n--------");
	}

	private static int[] sjzs() {
		int n=5+new Random().nextInt(6);
		int[]a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		return a;
	}

	private static void f(int[] a) {
//		boolean flag= false;
		for(int i=0;i<a.length;i++){
			for(int j=a.length-1;j>i;j--){
				if(a[j]<(a[j-1])){
					int t=a[j];
					a[j]=a[j-1];
					a[j-1]=t;
//					flag=true;
				}		
			}
//			if(flag==false){
//				break;
//			}
			System.out.println(Arrays.toString(a));
		}
	}
}
