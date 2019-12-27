package test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.junit.Test;

public class TestPx {
	@Test
	public void testPx() {
		int i,j,t;
		for ( i = 1; i<= 4; i++) {
			for ( j = 1; j <=4; j++) {
				for ( t = 1; t <=4; t++) {
					if(i!=j&&i!=t&&j!=t) {
					System.out.println(i+" "+j+" "+t);}
				}
			}
		}
	}
	@Test
	public void testMP() {
		int [] a= {1213,123,2345,45,123};
		Boolean flag=false;
		for (int i = 0; i < a.length; i++) {
			
			for (int j =a.length-1; j>i; j--) {
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
	@Test
	public void testRf() {
		int []a=suiji();
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int t = new Random().nextInt();
		int index=chazhao(a,t);
		if(index>=0) {
			System.out.println("下标位置是"+index);
		}else {
			System.out.println("下标不存在");
		}
		
	}
	private int chazhao(int[] a, int t) {
		int s=0;
		int w=a.length-1;
		int mid;
		
		return 0;
	}
	private int[] suiji() {
		int nextInt = 5+new Random().nextInt(20);
		int []a=new int[nextInt];
		for (int i = 0; i < a.length; i++) {
			a[i]=new Random().nextInt(100);
		}
		return a;
	}
	
	
}
