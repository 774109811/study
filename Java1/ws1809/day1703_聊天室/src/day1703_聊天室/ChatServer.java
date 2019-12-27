package day1703_聊天室;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class ChatServer {
	//创建通信线程集合
	private List<TongXinThread> list = new ArrayList<>();
	public void start(){
		//启动服务线程
		new Thread(){
			public void run() {//修改run方法
			try {
				ServerSocket ss = new ServerSocket(8000);//新建服务器
			System.out.println("服务器已启动");
			while(true){
				Socket s = ss.accept();//等待客户端发起连接，并建立连接通道
				System.out.println("服务器已接受客户端内容");
				TongXinThread t = new TongXinThread(s);//新建通信线程
				t.start();//启动线程
				synchronized (list) {//加锁
					list.add(t);// 通信线程对象加入集合
				}
				}
				} catch (Exception e) {
					System.out.println("服务器无法启动，或服务已停止");
				}
			}	
		}.start();		
	}
	class TongXinThread extends Thread{//新建通信线程内部类
		Socket s;//新建一个通道变量
		BufferedReader in;//新建一个缓存字符流
		PrintWriter out;//换行字符了
		String name ; //新建一名字
		public TongXinThread(Socket s) {
				this.s = s;
				
		}
		public void send(String msg) {//当前客户端发送数据
			out.println(msg);
			out.flush();
		}
		public void sendAll(String msg){//向所有客户端发送
			synchronized (list) {	
				for (TongXinThread t : list) {
					t.send(msg);
				}	
			}
		}
		public void run() {
				try {	
				in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
				out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
					 //先接受客户端的昵称
					 name = in.readLine();
					 //发送欢迎信息
					 send(name+",欢迎来到聊天室！");
					 synchronized (list) {
					//群发上线信息
					sendAll(name+"进入了聊天室，在线人数"+list.size());
					}
					 //设置时间
					 s.setSoTimeout(3000);//3秒超时出现异常
					 int count = 0;//初始值等于0
					 
					 String line;
					 while(true){
						 try {
							 line = in.readLine();
							 if(line == null){
								 break;
							 }
							sendAll(name+"说："+line);
							count =0;
						} catch (SocketTimeoutException e) {
							count++;
							if(count==4){
								send("***您已被踢");
								s.close();
								break;
							}
							send("***警告：请积极参与"+count+"/3)");
						}
					 }
				} catch (Exception e) {
				}
				synchronized (list) {
					//移除当前通信线程对象
				list.remove(this);
				//群发离线信息
				sendAll(name+"离开了聊天室，在线人数"+list.size());
		        }	
		       }
	         }
	public static void main(String[] args) {
		ChatServer s = new ChatServer();
		s.start();
	}
}
