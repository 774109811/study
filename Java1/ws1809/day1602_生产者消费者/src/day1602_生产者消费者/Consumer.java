package day1602_生产者消费者;
import java.util.Random;
public class Consumer extends Thread{
	 private Stack stack;
	 
	   public Consumer(Stack stack) {
	      this.stack = stack;
	   }
	   
	   @Override
	   public void run() {
	      while(true) {
	         synchronized (stack) {
	            //栈是空的，消费者线程等待
	            while(stack.isEmpty()) {
	                try {
	                   stack.wait();
	                } catch (InterruptedException e) {   
	                }
	            }
	            char c = stack.pop();
	            System.out.println("从仓库取出 << "+c);
	            //通知在栈对象上等待的其他线程
	            stack.notifyAll();
	         }
	      }
	   }
}
