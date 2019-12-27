package day0304;

public class Text1 {
	public static void main(String[] args) {
		double sum =0;
	
		for(int a=1,b= 1 , c=1; c<=1000  ;a=a*-1,b=b+2,c++ ){
			sum =sum+ a/(double)b ;
		}

		double	d =sum*4;
		System.out.println("¦Ð="+d);
	}
}
