package day0410_����;

import java.util.Arrays;

public class Text2 {
	public static void main(String[] args) {
		//�½�int[]���飬����10
	      //�ٰѵ�ַ�浽����a
		int []a=new int[10];
		
		 //�������飬����1,2,3...10
		for(int i=0;i<a.length;i++){
			a[i]=i+1;
			System.out.println(Arrays.toString(a));
		}
	}
}
