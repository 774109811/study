package day0501;

import java.util.Scanner;

public class Text1 {
	static String[] names={"iphoneX","��Ϊp28","С��","����","ŵ����"};
	static int[] numbers ={80,65,34,42,5};
	static double[] prices={8000,6500,3400,4200,5000};
	public static void main(String[] args) {
		outer:
			while(true){
				//	��ʾ�˵���������û�ѡ���ֵ
				int c= menu();
				switch(c){
				case 1: f1(); break;
				case 2: f2(); break;
				case 3: f3(); break;
				case 4: f4(); break;
				case 5: break outer;	 
				} 
			}
	}
	static int menu(){
		System.out.println("\n\n----------");
		System.out.println("1.��Ʒ�б�");
		System.out.println("2.��Ʒ¼��");
		System.out.println("3.��Ʒ��ѯ");
		System.out.println("4.ͳ����Ϣ");
		System.out.println("5.�˳�");
		System.out.println("--------------");
		System.out.print("ѡ��");
//		���������ֵ
		return new Scanner(System.in).nextInt();
	}
	static void f1(){
		for(int i=0;i<names.length;i++){
			String n=names[i];
			int b=numbers[i];
			double p=prices[i];
			System.out.println((i+1)+".���ƣ�"+n+"��������"+b+",�۸�"+p);
		}
		
	}
	static void f2(){
		for(int i=0;i<names.length;i++){
			System.out.println("\n�����"+(i+1)+"����Ʒ��");
			System.out.print("���ƣ�");
			names [i]=new Scanner(System.in).nextLine();
			System.out.print("������");
			numbers [i]=new Scanner(System.in).nextInt();
			System.out.print("�۸�");
			prices [i]=new Scanner(System.in).nextDouble();
		    
		}
		f1();
	}


	static void f3(){
		System.out.println("��ѯ����Ʒ���ƣ�");
		String t=new Scanner(System.in).nextLine();
		for(int i=0;i<names.length;i++){
			if(t.equals(names[i])){
				String n=names[i];
				int  b=numbers[i];
				double p=prices[i];
				System.out.println((i+1)+".���ƣ�"+n+"��������"+b+",�۸�"+p);
			    return;
			}
		}
		System.out.println("�Ҳ�������Ʒ");
	}
	static void f4(){
		double spzj =0;
		double djzj =0;
		double zgzj =0;
		double zgdj =0;
		for(int i=0;i<names.length;i++){
			spzj=spzj+numbers[i]*prices[i];
			djzj=(djzj+prices[i]);
			if( numbers[i]*prices[i]>zgzj){
			zgzj=numbers[i]*prices[i];
			}
			if( prices[i]>zgdj){
				zgdj=prices[i];
				}
		}
		System.out.println("��Ʒ�ܼ�"+spzj);
		System.out.println("���۾���"+djzj);
		System.out.println("����ܼ�"+zgzj);
		System.out.println("��ߴ��"+zgdj);
	}

}

