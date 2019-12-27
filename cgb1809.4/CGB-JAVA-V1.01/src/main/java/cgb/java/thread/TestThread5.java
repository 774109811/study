package cgb.java.thread;
/**
 * 用线程通讯的方式(wait,notify)，保证15行content值不为空
 * @author ta
 */
public class TestThread5 {

	static String content;
	public static void main(String[] args) throws InterruptedException {
	    new Thread(){
			@Override
			public  void run() {
				synchronized (TestThread5.class) {
					content="hello CGB-1809";
					TestThread5.class.notifyAll();
				}
			}
		}.start();
		synchronized(TestThread5.class){
		 while(content==null)
			 TestThread5.class.wait();
		 System.out.println(content.toUpperCase());
		}
	}
}
