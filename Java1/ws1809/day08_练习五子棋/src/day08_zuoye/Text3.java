package day08_zuoye;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Text3 {
	public static void main(String[] args) {
		int ary[]={11,2,3,4,5};
		System.out.println(Arrays.toString(ary));
		System.out.println("请输入要删除的下表值：");
		int index =new Scanner(System.in).nextInt();
		int[]b= remove(ary,index);
		System.out.println(Arrays.toString(b));
	}

	private static int[] remove(int[] ary, int index) {
		int []b=new int[ary.length-1];
		System.arraycopy(ary, 0, b, 0, index);
		System.arraycopy(ary, index+1, b, index, ary.length-index-1);
		return b;
	}


}
