package day1601_�߳�;

public class Text1 {
	//JVM����������󣬻��Զ�����һ��main�߳�
		//��main�߳��У�����main��������
		public static void main(String[] args) {
			T1 t1 = new T1();
			T1 t2 = new T1();
			//�����߳�
			//�߳��������Զ�ִ��run��������
			t1.start();
			t2.start();
			System.out.println("main�߳�ִ�еĴ���");
		}
		
		static class T1 extends Thread{
			@Override
			public void run() {
				//����̵߳�����
				//setName(name);ϵͳĬ����
				String n = getName();
				for(int i =1;i<=1000;i++){
					System.out.println(n+" - "+i);
				}
			}
			
			
		//��̬�ڲ��࣬����ʹ�ã�����ͨ��û������	
		}

}
