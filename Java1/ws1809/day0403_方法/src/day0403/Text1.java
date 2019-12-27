package day0403;

public class Text1 {
	public static void main(String[] args) {
		System.out.println(1);
		int a =f(2);
		System.out.println(a);
		
		System.out.println(3);
		System.out.println(f(4));
		
		System.out.println(5);
		System.out.println(f(6)+3);
		
	}
	static int f(int a){
//	 return a/2;
//   右移一位就是除以2
	 return a>>1;
	}
}
