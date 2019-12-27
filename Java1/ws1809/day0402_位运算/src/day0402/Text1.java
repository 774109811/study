package day0402;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("ÊäÈëÕûÊý£º");
		int a=new Scanner(System.in).nextInt();
		byte b =(byte)(a>>24);
		byte b1=(byte)(a>>16);
		byte b2=(byte)(a>>8);
		byte b3=(byte)(a>>0);
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		int r=0;
		r=r|(b<<24>>>0);
		r=r|(b1<<24>>>8);
		r=r|(b2<<24>>>16);
		r=r|(b3<<24>>>24);
		System.out.println(r);
	}
	
}
