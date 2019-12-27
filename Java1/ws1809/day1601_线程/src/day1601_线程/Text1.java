package day1601_线程;

public class Text1 {
	//JVM虚拟机启动后，回自动启动一个main线程
		//在main线程中，运行main（）方法
		public static void main(String[] args) {
			T1 t1 = new T1();
			T1 t2 = new T1();
			//启动线程
			//线程启动后，自动执行run（）方法
			t1.start();
			t2.start();
			System.out.println("main线程执行的代码");
		}
		
		static class T1 extends Thread{
			@Override
			public void run() {
				//获得线程的名字
				//setName(name);系统默认有
				String n = getName();
				for(int i =1;i<=1000;i++){
					System.out.println(n+" - "+i);
				}
			}
			
			
		//静态内部类，单独使用，和普通类没有区别	
		}

}
