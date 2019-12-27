package day0306;

public class Text1 {
	public static void main(String[] args) {
		for(int g=0;g<=20  ;g++ ){
			int money =100-g*5;
			int max = money/3;
			for(int m =0; m<=max;m++ ){
			int x = (money-3*m)*3;
			if(g+m+x == 100){
				System.out.println("¹«¼¦:"+g+"Ä¸¼¦"+m+"Ð¡¼¦"+x);
			}
			
				
		}
	}
	}
}

