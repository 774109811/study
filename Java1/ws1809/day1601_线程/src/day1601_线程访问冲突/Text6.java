package day1601_�̷߳��ʳ�ͻ;

public class Text6 {
public static void main(String[] args) {
		//������ͬ����������������r1
		R1 r1 =new R1();
		Thread t1 = new Thread(r1);
		t1.start();//r1.add()i++,i++....
		//��main�̼߳�����ֵ�ǲ��ǻ����Ȼ�����ֵ
		while(true){
			int i = r1.get();//return i
			if(i%2==1){
				System.out.println(i);//��ӡ��������
				System.exit(0);//�˳������
			}
		}
	}
	static class R1 implements Runnable{
		static int i=0;
		public synchronized void add(){
			i++;
			i++;
		}
		public synchronized int get(){
			return i;
		}
		@Override
		public void run() {
			while(true){
				add();
			}
			
		}
		
		
	}

}
