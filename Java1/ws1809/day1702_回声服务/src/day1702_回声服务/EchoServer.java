package day1702_��������;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {//����������
	public void start() {
		//���������߳�
		new Thread(){//�½��߳����������߳�
			public void run() {//�޸�run����
				try {
					//��������
					ServerSocket ss = new ServerSocket(8000);//�½�������
					System.out.println("��������");
					while(true){
					Socket s = ss.accept();//�����ȴ��ͻ��˷������ӣ���������ͱ�Ĵ��벢��
					//��socket����ͨ������ͨ���߳�ȡִ��ͨ�Ų���
					TongXinThread t = new TongXinThread(s);	
					t.start();
					}		
				} catch (Exception e) {
					System.out.println("�����޷��������������ֹͣ");
					e.printStackTrace();
				}};}.start();
	}
	class TongXinThread extends Thread{//ͨ���̷߳���
		Socket s;//���ܶ���
		public TongXinThread(Socket s) {
			this.s = s;
		}
		@Override
		public void run() {//ִ��ͨ��
			try {
				//ͨ��Э��
				//ͨ������    ѭ���ӿͻ��˽������ݣ��յ��������ڷ��ؿͻ���
				//���ݸ�ʽ    UTF-8������ַ�����ÿһ����ΪҪ��һ�����з� 
				// BR--ISR --������
				//   PW-0SW-���������	
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
				PrintWriter   out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
				String line;
				while((line=in.readLine())!=null){
					out.println(line);
					out.flush();
				}	
				//���жϿ�
			} catch (Exception e) {
				// nullֵ�쳣�Ͽ�
			}
			System.out.println("�ͻ��˶Ͽ�����");
		}
	}
	public static void main(String[] args) {
		EchoServer s = new EchoServer();//�½����ķ���������
		s.start();
	}	
}
