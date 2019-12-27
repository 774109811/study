package test.java;

import java.util.Scanner;

import org.junit.Test;

public class Digui {
	@Test
	public void test() {
		int nextInt = new Scanner(System.in).nextInt();
		long a=f(nextInt);
		System.out.println(a);
	}

	private long f(int i) {
		if(i==0) {
			return 1;
		}
		 return i*f(i-1);
		
	}
}
