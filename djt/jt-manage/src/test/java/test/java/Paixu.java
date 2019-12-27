package test.java;

import java.util.Arrays;

import org.junit.Test;

public class Paixu {


	@Test
	public void paixu() {
		int count=0;
		int i,j,k;
		for( i=1;i<=4;i++) {
			for( j=1;j<=4;j++) {
				for( k=1;k<=4;k++) {
					if(i!=j&&i!=k&&j!=k) {
						System.out.println(i+" "+j+" "+k);
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
	@Test
	public void test() {
		String str = new String("abc");
		String str1 = "abc";
		
		boolean equals = str.equals(str1);
		System.out.println(equals);
	}
	
}
