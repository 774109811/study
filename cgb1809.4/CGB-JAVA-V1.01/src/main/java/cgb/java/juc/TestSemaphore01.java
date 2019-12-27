package cgb.java.juc;
import java.util.concurrent.Semaphore;
public class TestSemaphore01 {
	/**
	 * 高并发环境下的限流策略。
	 */
	static class LimitService{
		//创建一个限流的锁
		private Semaphore sh=new Semaphore(1,true);
		//业务
		public void service(){
			try{
			//获取一个信号量(令牌)
			  sh.acquire();
			  //才能执行业务
			  String tName=Thread.currentThread().getName();
			  System.out.println("服务于当前线程:"+tName);
			  try{Thread.sleep(2000);}catch(Exception e){}
			}catch(Exception e){
			 e.printStackTrace();
			}finally{
				//用完退出后 释放
			  sh.release();//释放信号量(令牌)
			}
		}
	}
	public static void main(String[] args) {
		LimitService limitService=new LimitService();
		for(int i=0;i<30;i++){
			new Thread(){
				public void run() {
					limitService.service();
				};
			}.start();
		}
	}
}
