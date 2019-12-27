package day0301;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("\n\n-----");
		f1();
	}
	 static void f1(){
		 for(int i=1;i<=3;i++){
			 for(char j = 'a';j<='c';j++){
				 System.out.print(i+"*"+j);
			 }
			 System.out.println();
		 }
	 }

}
