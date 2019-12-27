package day0202;

public class Tss1 {
	public static void main(String[]args){
		System.out.println("两星相距6.4光年");
		System.out.println("光速10米/秒");
		System.out.println("喜鹊长10米");
		System.out.println("秀朗织女相距多少米");
		long a = 10*60*60*24*365;
		double b = a*6.4;
		double c =b/10;
		long d = (long) Math.ceil(c);
		System.out.println("相距"+d+'米');
		
		
		
	}

}
