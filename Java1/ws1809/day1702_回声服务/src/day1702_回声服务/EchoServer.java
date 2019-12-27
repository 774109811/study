package day1702_回声服务;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {//回声服务器
	public void start() {
		//启动服务线程
		new Thread(){//新建线程子类阻塞线程
			public void run() {//修改run方法
				try {
					//启动服务
					ServerSocket ss = new ServerSocket(8000);//新建服务器
					System.out.println("服务启动");
					while(true){
					Socket s = ss.accept();//反复等待客户端发起连接，阻塞代码和别的代码并行
					//把socket连接通道交给通信线程取执行通信操作
					TongXinThread t = new TongXinThread(s);	
					t.start();
					}		
				} catch (Exception e) {
					System.out.println("服务无法启动，或服务已停止");
					e.printStackTrace();
				}};}.start();
	}
	class TongXinThread extends Thread{//通信线程方法
		Socket s;//接受对象
		public TongXinThread(Socket s) {
			this.s = s;
		}
		@Override
		public void run() {//执行通信
			try {
				//通信协议
				//通信流程    循环从客户端接受数据，收到的数据在发回客户端
				//数据格式    UTF-8编码的字符串，每一行行为要有一个换行符 
				// BR--ISR --网络流
				//   PW-0SW-网络输出流	
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
				PrintWriter   out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
				String line;
				while((line=in.readLine())!=null){
					out.println(line);
					out.flush();
				}	
				//换行断开
			} catch (Exception e) {
				// null值异常断开
			}
			System.out.println("客户端断开连接");
		}
	}
	public static void main(String[] args) {
		EchoServer s = new EchoServer();//新建它的方法，启动
		s.start();
	}	
}
