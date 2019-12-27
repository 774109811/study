package day1602_生产者消费者;
import java.util.Random;
public class Producer extends Thread {
	 private Stack stack;
	 
	   public Producer(Stack stack) {
	      this.stack = stack;
	   }
	   
	   @Override
	   public void run() {
	      while(true) {
	         // a-z
	         // 'a'+[0, 26)
	         char c = 
	          (char) ('a'+new Random().nextInt(26));
	         synchronized (stack) {//同步仓库锁
	            while(stack.isFull()) {//如果是满的
	                try {
	                   stack.wait();//生产就给我等着
	                } catch (InterruptedException e) {
	                }
	            }
	            stack.push(c);//放入
	            System.out.println("放入仓库 >> "+c);
	            stack.notifyAll();
	         }
	      }
	   }
	       
	     
	   
}
