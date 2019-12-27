package day1601_线程;

public class Text2 {
	public static void main(String[] args) {
		R1 r = new R1();//包含代码的对象
		Thread t1 = new Thread(r,"t1");
		Thread t2 = new Thread(r,"t2");
		//启动的是Runnable 对象的run方法
		t1.start();
		t2.start();
	}
	
	static class R1 implements Runnable{

		@Override
		public void run() {
			//先获得正在执行的线程对象,类名调用
			Thread t = Thread.currentThread();
			String n = t.getName();
			for(int i = 1;i<=1000;i++){
				System.out.println(n+" - "+i);
			}
			
		}
		
		
	}

}
