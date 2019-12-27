package day0407;

public class Text1 {
	public static void main(String[]args){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				if(j==3&&(i==3||i==4)){
					System.out.print(" ");
				}
				System.out.print(i+"*"+j+"="+(j*i)+" ");
			}
			System.out.println();
		}
		
	}
}
