package day17_��ϰ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		Socket s = new Socket("176.201.103.9",8000);
		
			BufferedReader in  = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
			
			while(true) {
				System.out.println("���룺");
				String str = new Scanner(System.in).nextLine();
				out.println(str);
				out.flush();
				System.out.println("�����Ѿ�������������");
				str = in.readLine();
				System.out.println("�յ�����������"+str);
				
				
			}
			
	
		
		
	}
	
}
