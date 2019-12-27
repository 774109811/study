package day16_Á·Ï°ruanable;

public class Text1 {
	public static void main(String[] args) {
		R1 r1 = new R1();
		Thread t = new Thread(r1," 1 ");
		Thread t1= new Thread(r1," 2 ");
		t.start();
		t1.start();
		
	}
	static class R1 implements Runnable{
		
			public void run() {
				Thread t = Thread.currentThread();
				t.getName();
				for (int i = 0; i < 1000; i++) {
					System.out.println(t.getName()+"-"+i);
				}
			}
		}
	}

