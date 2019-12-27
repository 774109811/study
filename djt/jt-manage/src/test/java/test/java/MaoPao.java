package test.java;

import java.util.Arrays;

public class MaoPao {
	public static void main(String[] args) {
		int[]a= {11,123,12,213,1243,333};
		
		sort(a);
	}

	private static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			boolean flag=false;
			for (int j=a.length-1 ; j>i; j--) {
				if(a[j]<a[j-1]) {
					int t=a[j];
					a[j]=a[j-1];
					a[j-1]=t;
					flag=true;
				}	
			}
			if(!flag) {
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
