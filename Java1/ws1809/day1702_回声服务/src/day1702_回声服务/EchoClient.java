package day1702_回声服务;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("176.201.103.17",8000);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
		PrintWriter   out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
		
		while(true){
			System.out.println("输入：");
			String str = new Scanner(System.in).nextLine();
			out.println(str);
			out.flush();
			System.out.println("内容已经发送至服务器");
			str = in.readLine();
			System.out.println("收到服务器回信："+str);
		}
		
		
	}
}
