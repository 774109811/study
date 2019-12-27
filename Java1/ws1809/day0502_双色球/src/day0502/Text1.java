package day0502;

import java.util.Arrays;
import java.util.Random;

public class Text1 {

	public static void main(String[] args) {
		int[]r=zbsz(33);
		int[]b=zbsz(16);
		System.out.println(Arrays.toString(r));
		System.out.println(Arrays.toString(b));
		int[]red=xuanRed(r);
		int blue=xuanBlue(b);
		System.out.println(Arrays.toString(red));
		System.out.println(blue);
		
	}
	private static int xuanBlue(int[] b) {
		return b[new Random().nextInt(16)];
		
	}
	private static int[] xuanRed(int[] r) {
		for(int i=0;i<6;i++){
			int j=new Random().nextInt(33);
			int t=r[i];
			r[i]=r[j];
			r[j]=r[t];
		}
		return Arrays.copyOf(r, 6);
	}
	static int[] zbsz(int n){
		int[]a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=i+1;
		}
		return a;
	}

}
