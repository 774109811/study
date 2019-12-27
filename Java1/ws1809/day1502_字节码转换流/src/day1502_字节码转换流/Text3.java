package day1502_×Ö½ÚÂë×ª»»Á÷;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Text3 {
	public static void main(String[] args) throws Exception {
		//BR--ISR--FIS--f7,utf-8
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("d:/abc/f7"),"UTF-8")); 
		String line;
		while((line=in.readLine())!=null){
			System.out.println(line);
			 new Scanner(System.in).nextLine();
		}
		in.close();
	}

}
