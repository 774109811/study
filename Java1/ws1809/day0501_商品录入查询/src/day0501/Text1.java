package day0501;

import java.util.Scanner;

public class Text1 {
	static String[] names={"iphoneX","华为p28","小米","锤子","诺基亚"};
	static int[] numbers ={80,65,34,42,5};
	static double[] prices={8000,6500,3400,4200,5000};
	public static void main(String[] args) {
		outer:
			while(true){
				//	显示菜单，并获得用户选择的值
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
		System.out.println("1.商品列表");
		System.out.println("2.商品录入");
		System.out.println("3.商品查询");
		System.out.println("4.统计信息");
		System.out.println("5.退出");
		System.out.println("--------------");
		System.out.print("选择：");
//		返回输入的值
		return new Scanner(System.in).nextInt();
	}
	static void f1(){
		for(int i=0;i<names.length;i++){
			String n=names[i];
			int b=numbers[i];
			double p=prices[i];
			System.out.println((i+1)+".名称："+n+"，数量："+b+",价格："+p);
		}
		
	}
	static void f2(){
		for(int i=0;i<names.length;i++){
			System.out.println("\n输入第"+(i+1)+"件商品：");
			System.out.print("名称：");
			names [i]=new Scanner(System.in).nextLine();
			System.out.print("数量：");
			numbers [i]=new Scanner(System.in).nextInt();
			System.out.print("价格：");
			prices [i]=new Scanner(System.in).nextDouble();
		    
		}
		f1();
	}


	static void f3(){
		System.out.println("查询的商品名称：");
		String t=new Scanner(System.in).nextLine();
		for(int i=0;i<names.length;i++){
			if(t.equals(names[i])){
				String n=names[i];
				int  b=numbers[i];
				double p=prices[i];
				System.out.println((i+1)+".名称："+n+"，数量："+b+",价格："+p);
			    return;
			}
		}
		System.out.println("找不到此商品");
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
		System.out.println("商品总价"+spzj);
		System.out.println("单价均价"+djzj);
		System.out.println("最高总价"+zgzj);
		System.out.println("最高大家"+zgdj);
	}

}

