package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtInteger {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		int t=1;
		for(int i=1;i<=4;i++) {
			switch (i) {
			case 1:
				t = atomicInteger.getAndAdd(1);
				break;
			case 2:
				t = atomicInteger.getAndAdd(1);
				break;
			case 3:
				t = atomicInteger.getAndAdd(1);
				break;
			case 4:
				t = atomicInteger.getAndAdd(1);
				break;	
			}
		}
		System.out.println(t);
	}
}
