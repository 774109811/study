package day1601_�̷߳��ʳ�ͻ;

public class Text7 {
public static void main(String[] args) {
		//������ͬ����������������r1
		R1 r1 =new R1();
		Thread t1 = new Thread(r1);
		t1.start();//r1.add()i++,i++....
		//��main�̼߳�����ֵ�ǲ��ǻ����Ȼ�����ֵ
		R1 r2 =new R1();//�ڴ�������R2��һ��
		while(true){
			int i = r2.get();//return i
			if(i%2==1){
				System.out.println(i);//��ӡ��������
				System.exit(0);//�˳������
			}
		}
	}
	static class R1 implements Runnable{
		static int i=0;
		public static synchronized void add(){//��static���Ƕ��õ�R1����
			i++;
			i++;
		}
		public static synchronized int get(){
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
