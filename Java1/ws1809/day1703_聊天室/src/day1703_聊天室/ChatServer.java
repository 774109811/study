package day1703_������;

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
	//����ͨ���̼߳���
	private List<TongXinThread> list = new ArrayList<>();
	public void start(){
		//���������߳�
		new Thread(){
			public void run() {//�޸�run����
			try {
				ServerSocket ss = new ServerSocket(8000);//�½�������
			System.out.println("������������");
			while(true){
				Socket s = ss.accept();//�ȴ��ͻ��˷������ӣ�����������ͨ��
				System.out.println("�������ѽ��ܿͻ�������");
				TongXinThread t = new TongXinThread(s);//�½�ͨ���߳�
				t.start();//�����߳�
				synchronized (list) {//����
					list.add(t);// ͨ���̶߳�����뼯��
				}
				}
				} catch (Exception e) {
					System.out.println("�������޷��������������ֹͣ");
				}
			}	
		}.start();		
	}
	class TongXinThread extends Thread{//�½�ͨ���߳��ڲ���
		Socket s;//�½�һ��ͨ������
		BufferedReader in;//�½�һ�������ַ���
		PrintWriter out;//�����ַ���
		String name ; //�½�һ����
		public TongXinThread(Socket s) {
				this.s = s;
				
		}
		public void send(String msg) {//��ǰ�ͻ��˷�������
			out.println(msg);
			out.flush();
		}
		public void sendAll(String msg){//�����пͻ��˷���
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
					 //�Ƚ��ܿͻ��˵��ǳ�
					 name = in.readLine();
					 //���ͻ�ӭ��Ϣ
					 send(name+",��ӭ���������ң�");
					 synchronized (list) {
					//Ⱥ��������Ϣ
					sendAll(name+"�����������ң���������"+list.size());
					}
					 //����ʱ��
					 s.setSoTimeout(3000);//3�볬ʱ�����쳣
					 int count = 0;//��ʼֵ����0
					 
					 String line;
					 while(true){
						 try {
							 line = in.readLine();
							 if(line == null){
								 break;
							 }
							sendAll(name+"˵��"+line);
							count =0;
						} catch (SocketTimeoutException e) {
							count++;
							if(count==4){
								send("***���ѱ���");
								s.close();
								break;
							}
							send("***���棺���������"+count+"/3)");
						}
					 }
				} catch (Exception e) {
				}
				synchronized (list) {
					//�Ƴ���ǰͨ���̶߳���
				list.remove(this);
				//Ⱥ��������Ϣ
				sendAll(name+"�뿪�������ң���������"+list.size());
		        }	
		       }
	         }
	public static void main(String[] args) {
		ChatServer s = new ChatServer();
		s.start();
	}
}
