package day0402_λ����;

import java.util.Scanner;

public class Text1 {

	public static void main(String[] args) {
//		10����ֵ��ת��2�����ַ���
//		Integer.toBinaryString();
//		456123---->"1010100010100"
//		1010100010100
//		      i
//      1010100010100      
		System.out.println("����������");
		int a= new Scanner(System.in).nextInt();
		String r="";
		for(int i=0;i<32;i++){
			int t=1<<i;
			int b=t&a;
			if(b==0){
				r='0'+r;
			}else{
				r='1'+r;
			}
		}
		System.out.println(r);
	}

}
