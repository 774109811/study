package day1203;

import java.util.HashMap;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("�����ַ�����");
		String s = new Scanner(System.in).nextLine();
		//�½�HashMap
		HashMap<Character, Integer> map = new HashMap<>();
		//�����ַ���s
		for(int i =0;i<s.length();i++){
			//ȡ��iλ���ַ�
			char c = s.charAt(i);
			//��map��ȡc��Ӧ�ļ���ֵ
	       Integer count = map.get(c);
           // ���count��nullû�������ĸ���Ƿ���1��
	       if(count == null){
	    	   map.put(c,1);
	       }else{
//	    	   ����еĻ��ͼ�һ��
	    	   map.put(c,count+1);
	       }
	    }
//		��ӡmap�ļ���
	    System.out.println(map);
	}
}
