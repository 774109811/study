package day1701_����;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws Exception {
		//127.0.0.1  loc
		//�½� �ͻ���S
		Socket s = new Socket("176.201.103.11",8000);
		//��������������
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		//ͨ�ŵ�Э��
				//ͨ�ŵĲ���         1���������ݣ� 2���������� 
				//ͨ�ŵ����ݸ�ʽ1������hello���Ӣ���ַ� 2������world���Ӣ���ַ�
		System.out.println("�����������Hello");
		out.write("Hello".getBytes());
		out.flush();
		System.out.println("�������");
		System.out.println("\n\n---------");
		System.out.println("�ӷ���������");
		for (int i = 0; i < 5; i++) {
			char c= (char) in.read();
			System.out.print(c);
		}
		System.out.println("�������");
		s.close();
	}
}
