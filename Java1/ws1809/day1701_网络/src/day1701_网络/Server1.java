package day1701_����;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//ѡ��һ���˿ڣ�����������
		//�˿��������������ռ�ã������
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("����������");
		//�ȴ��ͻ��˷������ӣ���������ͨ��
		Socket s = ss.accept();
		//������ͨ��,���˫����
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		//ͨ�ŵ�Э��
		//ͨ�ŵĲ���          1����������2���������ݣ�  
		//ͨ�ŵ����ݸ�ʽ 1������hello���Ӣ���ַ� 2������world���Ӣ���ַ�
		for (int i = 0; i < 5; i++) {
			 char c =(char)in.read();//���ص�����������intת��char����
			 System.out.print(c);
		}
		System.out.println("\n\n------------");
		out.write("world".getBytes());//����ת��getBytesת������
		out.flush();//ˢ��
		s.close();//�Ͽ�����
		ss.close();//ֹͣ�����ͷŶ˿�
	}
}
