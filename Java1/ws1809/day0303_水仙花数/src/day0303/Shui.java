package day0303;

public class Shui {
	public static void main(String[] args) {
		for(int a=1;a<100000;a++){
			int b=a%10;
			int c=b/10%10;
			int d=c/10%10%10;
			int e=d/10%10%10%10;
			int f=e/10000;
			if(b*b*b*b*b+c*c*c*c*c+d*d*d*d*d+e*e*e*e*e+f*f*f*f*f*f == a){
				System.out.println(a);
			}
			
			
			
		}
		
	}

}
