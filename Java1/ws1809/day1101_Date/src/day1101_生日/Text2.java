package day1101_����;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) throws ParseException {
		   System.out.println("����������(yyyy-MM-dd):");
		   String r = new Scanner(System.in).nextLine();
		   SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		   //�ַ���r ������Date ����
		   Date a = sdf.parse(r);
		   //��ǰʱ���ȥ�Լ������ʱ��
		   long t =System.currentTimeMillis()-a.getTime();
		   t= t/1000/60/60/24;
		   System.out.println("���Ѿ�������"+t+"��");
		   Date d = new Date(10000L );   
		   System.out.println(d.getTime());
	}
}
