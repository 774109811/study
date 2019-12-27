package day1601_线程访问冲突;

public class Text7 {
public static void main(String[] args) {
		//让他们同步，不让有奇数用r1
		R1 r1 =new R1();
		Thread t1 = new Thread(r1);
		t1.start();//r1.add()i++,i++....
		//在main线程检查这个值是不是基数先获得这个值
		R1 r2 =new R1();//在创建，用R2试一下
		while(true){
			int i = r2.get();//return i
			if(i%2==1){
				System.out.println(i);//打印是奇数的
				System.exit(0);//退出虚拟机
			}
		}
	}
	static class R1 implements Runnable{
		static int i=0;
		public static synchronized void add(){//加static后是顶用的R1的锁
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
