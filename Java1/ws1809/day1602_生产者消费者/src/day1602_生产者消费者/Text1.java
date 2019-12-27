package day1602_生产者消费者;

public class Text1 {
	 public static void main(String[] args) {
	      Stack stack = new Stack();//新建一个仓库
	      Producer p = new Producer(stack);//生产者生产放到仓库
	      Consumer c = new Consumer(stack);//消费者从仓库取出
	      p.start();//启动
	      c.start();//启动
	      //main
	      while (true){
	    	  synchronized (stack) {//加锁
			stack.notifyAll();	
			}
	      }
	      
	   }
}
