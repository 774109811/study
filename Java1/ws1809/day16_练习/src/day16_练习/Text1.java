package day16_¡∑œ∞;

public class Text1 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T1 t2 = new T1();
		t1.start();
		t2.start();
		System.out.println("mainœﬂ≥Ã");
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	static class T1 extends Thread{
		@Override
		public void run() {
			 String s =getName();
			 for(int i =1;i<1000;i++){
				 System.out.println(s+" - "+i);
			 }
		}
	}
}
