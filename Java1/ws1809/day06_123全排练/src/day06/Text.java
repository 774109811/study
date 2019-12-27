package day06;

import java.util.Arrays;

public class Text {
	public static void main(String[] args) {
		int[]a={2,1,3};
//		对0位置开始的所以值全排列
		f(a,0);
	}

	private static void f(int[] a, int start) {
//		  start
		/* |
		 * 123
		 * i
		 * 
		 * 在start位置，固定一个值
		 * /对start+1后面的值全排列
		 * 最简问题
		 * start在末尾位置，只对末尾一个值排列
		 */
		if(start==a.length-1){
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start;i<a.length;i++){
//			i和start位置交换
			swap(a,i,start);
			f(a,start+1);
//			递归对start+1之后的值全排列
			//在交换回来，否则会引起数据混乱
			swap(a,i,start);
		}
	}
	private static void swap(
			int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
