package day16_jion;

public class Text4 {
	public static void main(String[] args) {
		
		f1();
		f2();
		
	}
	private static void f2() {
		long t = System.currentTimeMillis();
		T1 t1 = new T1(0,200000);
		T1 t2 = new T1(200000,400000);
		T1 t3 = new T1(400000,800000);
		T1 t4 = new T1(800000,1000000);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int sum=t1.count+t2.count+t3.count+t4.count;
		System.out.println("质数"+sum);
		t=System.currentTimeMillis()-t;
		System.out.println("时间"+t);
	}
	private static void f1() {
		T1 t1 = new T1(0,10000000);
		long t = System.currentTimeMillis();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t1.count);
		t=System.currentTimeMillis()-t;
		System.out.println("时间"+t);
	}
	static class T1 extends Thread{
		int start;
		int end;
		int count;
		public T1(int start, int end) {
			if(start<3){
				start =3;
				count =1;
			}
			this.start = start;
			this.end = end;
		}
		@Override
		public void run() {
			for (int i = start; i < end; i++) {
				//
				if(isPrime(i)){
					count++;
				}
			}
		}
		private boolean isPrime(int i) {
			double max =1+Math.sqrt(i);
			for(int j=2;i<max;j++){
				if(i%j==0){
					return false;
				}
			}
			return true;
		}
		
	}
	
}
