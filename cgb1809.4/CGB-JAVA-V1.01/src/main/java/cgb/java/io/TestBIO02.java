package cgb.java.io;
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
public class TestBIO02 {
	
	@Test
	public void doServer()throws Exception{	
		ServerSocket server=
				//创建一个服务器
		new ServerSocket(9090);
		System.out.println("server start");
		//等待客户端的连接
		Socket socket=server.accept();//阻塞式方法
		System.out.println("client connection");
		ObjectInputStream ois=
				//服务器接受客户端输出的信息
		new ObjectInputStream(socket.getInputStream());
		String content=ois.readUTF();//读取信息
		System.out.println("server read "+content);
		//关闭连接
		socket.close();
		//关闭服务器
		server.close();
	}
	@Test
	public void doClient()throws Exception{
		//新建一个客户端
		Socket socket=new Socket();
		//连接Ip和端口号
		socket.connect(new InetSocketAddress("127.0.0.1", 9090));
		//给服务器输出信息
		OutputStream out=socket.getOutputStream();
		ObjectOutputStream oos=
				//
		new ObjectOutputStream(out);//装饰模式
		oos.writeUTF("hello server");
		oos.close();
		socket.close();
	}
}








