package day08_zuoye;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Text2 {
	public static void main(String[] args) {
//		int[]ary={2,3,4,5,6};
//	
		int a =1+new Random().nextInt(6);
		int[]ary=new int[a];
	    for (int i = 0; i < ary.length; i++) {
			ary[i]=1+new Random().nextInt(100);
		}
		System.out.println(Arrays.toString(ary));
		int index =new Scanner(System.in).nextInt();
		int[]b = remove (ary,index);
		System.out.println(Arrays.toString(b));
	}

	private static int[] remove(int[] ary, int index) {
	        for(int i=index;i<ary.length-1;i++ ){
	        	ary[i]=ary[i+1];
	        }
	        int[]b=new int[ary.length-1];
	        System.arraycopy(ary, 0, b, 0, ary.length-1);
	        return b;
	        
	}

//	private static int[] remove(int[] ary, int index) {
//		int[]r=new int[ary.length-1];
//		System.arraycopy(ary, 0, r, 0, index);
//		System.arraycopy(ary, index+1, r, index, ary.length-index-1);
//		return r; 
//	}




}
