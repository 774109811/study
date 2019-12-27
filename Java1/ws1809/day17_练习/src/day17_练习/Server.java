package day17_��ϰ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void start() {
		new Thread() {
			
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(8000);
					System.out.println("������������");
					Socket s = ss.accept();
					TongxinThread t = new TongxinThread(s);
					t.start();
					
				} catch (IOException e) {
					System.out.println("�������޷���������������ر�");
					e.printStackTrace();
				}						
			};		
		}.start();		
	}
	class TongxinThread extends Thread{
		Socket s;
		
		public TongxinThread(Socket s) {
			this.s = s;
		}
		
		@Override
		public void run() {
			
		 try {
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
			String line;
			while((line=in.readLine())!=null) {
				out.println(line);
				out.flush();	
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�ͻ������ӶϿ�");	
			
		}
		
		
	}
	public static void main(String[] args) {
		Server s = new Server();
		s.start();
	}
}
