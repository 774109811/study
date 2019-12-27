package day1701_网络;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//选择一个端口，启动服务器
		//端口如果被其他程序占用，会出错
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("服务已启动");
		//等待客户端发起连接，建立连接通信
		Socket s = ss.accept();
		//从链接通道,获得双向流
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		//通信的协议
		//通信的步骤          1，接受数据2，发送数据，  
		//通信的数据格式 1，接受hello五个英文字符 2，发送world五个英文字符
		for (int i = 0; i < 5; i++) {
			 char c =(char)in.read();//返回的数据类型是int转成char类型
			 System.out.print(c);
		}
		System.out.println("\n\n------------");
		out.write("world".getBytes());//编码转换getBytes转换编码
		out.flush();//刷出
		s.close();//断开连接
		ss.close();//停止服务，释放端口
	}
}
