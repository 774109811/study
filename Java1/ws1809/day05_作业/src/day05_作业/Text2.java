package day05_ื๗าต;

import java.util.Arrays;
import java.util.Random;

public class Text2 {
	public static void main(String[] args) {
		int[]a=suiji();
		int[]b=suiji();
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		int[]c=hebing(a,b);
		System.out.println(Arrays.toString(c));
	}

	private static int[] hebing(int[] a, int[] b) {
		int j=0;
		int k=0;
		int []c=new int[a.length+b.length];
		for(int i=0;i<c.length;i++){
			if(j==a.length){
				c[i]=b[k];
				k++;
				continue;
			}else if(k==b.length){
				c[i]=a[j];
				j++;
				continue;
			}
			if(a[j]<b[k]){
				c[i]=a[j];
				j++;
			}else{
				c[i]=b[k];
				k++;
			}
		}
		return c;		
	}

	private static int[] suiji() {
		int n=5+new Random().nextInt(6);
		int[]a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		return a;
	}
}
