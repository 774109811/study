package day1701_网络;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws Exception {
		//127.0.0.1  loc
		//新建 客户端S
		Socket s = new Socket("176.201.103.11",8000);
		//输入和输出网络流
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		//通信的协议
				//通信的步骤         1，发送数据， 2，接受数据 
				//通信的数据格式1，发送hello五个英文字符 2，接受world五个英文字符
		System.out.println("向服务器发送Hello");
		out.write("Hello".getBytes());
		out.flush();
		System.out.println("发送完成");
		System.out.println("\n\n---------");
		System.out.println("从服务器接收");
		for (int i = 0; i < 5; i++) {
			char c= (char) in.read();
			System.out.print(c);
		}
		System.out.println("接受完毕");
		s.close();
	}
}
