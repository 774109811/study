package day08_zuoye;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
//		int[] a =new int[10];
//		a=new int[]{1,3,5,7,9,11,13,15,17,19};
		
		
		int[]a=new int[10];
		for(int i=0;i<a.length;i++){
			a[i]=2*i+1;
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println("-----------");
		for(int i=0;i<a.length;i++){                                                                                                                                      
			boolean flag =false;
			for(int j=a.length-1;j>i;j--){
				if(a[j]>a[j-1]){
					int t=a[j];
					a[j]=a[j-1];
					a[j-1]=t;
					flag=true;
				}else{
					
					break;
				}
//				System.out.println(Arrays.toString(a));
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
