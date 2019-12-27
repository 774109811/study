package cgb.java.io;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
public class TestBIO03 {
	
	@Test
	public void doServer()throws Exception{
		//构建一个阻塞式队列(用于存储任务)
		BlockingQueue<Runnable> workQueue=
		new LinkedBlockingQueue<>(10);
		ThreadPoolExecutor tPool=
				//创建一个线程池
		new ThreadPoolExecutor(10, 10,30,TimeUnit.SECONDS,workQueue);
		ServerSocket server=new ServerSocket(9090);
		System.out.println("server start");
		//等待客户端的连接
		while(true){
		Socket socket=server.accept();//阻塞式方法
		System.out.println("client connection");
		tPool.execute(new Runnable() {
			@Override
			public void run() {
				try{
					//负责读数距
						
			  String tName= Thread.currentThread().getName();
						
				ObjectInputStream ois=
				new ObjectInputStream(socket.getInputStream());
				String content=ois.readUTF();
				System.out.println(tName+"server read "+content);
				//socket.close();
				}catch(Exception e){
				e.printStackTrace();
				}finally{
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		}
		//server.close();
	}
	@Test
	public void doClient()throws Exception{
		for(int i=0;i<10;i++) {
		Socket socket=new Socket();
		socket.connect(new InetSocketAddress("127.0.0.1", 9090));
		OutputStream out=socket.getOutputStream();
		ObjectOutputStream oos=
		new ObjectOutputStream(out);//装饰模式
		oos.writeUTF("hello server "+System.currentTimeMillis());
		oos.close();
		socket.close();}
		while(true){}
	}
}








