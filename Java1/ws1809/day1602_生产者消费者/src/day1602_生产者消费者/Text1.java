package day1602_������������;

public class Text1 {
	 public static void main(String[] args) {
	      Stack stack = new Stack();//�½�һ���ֿ�
	      Producer p = new Producer(stack);//�����������ŵ��ֿ�
	      Consumer c = new Consumer(stack);//�����ߴӲֿ�ȡ��
	      p.start();//����
	      c.start();//����
	      //main
	      while (true){
	    	  synchronized (stack) {//����
			stack.notifyAll();	
			}
	      }
	      
	   }
}
