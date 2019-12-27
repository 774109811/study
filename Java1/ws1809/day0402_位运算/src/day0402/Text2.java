package day0402;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("ÊäÈëÕûÊý£º");
		int a= new Scanner(System.in).nextInt();
		byte b=(byte)(a>>24);
		byte c=(byte)(a>>16);
		byte d=(byte)(a>>8);
		byte e=(byte)(a>>0);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		int r=0;
		r=r|(b<<24>>>0);
		r=r|(c<<24>>>8);
		r=r|(d<<24>>>16);
		r=r|(e<<24>>>24);
		System.out.println(r);
		
		
		
		
		
	}
}
