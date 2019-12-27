package day0801;

import java.util.Scanner;

public abstract class GuessGame {
	public void start(){
		String r= suiji();
	
	System.out.println(r);
	tishi();
	while(true){
		System.out.println("²Â£º");
		String c= new Scanner(System.in).nextLine();
		String result =bijiao(c,r);
		System.out.println(result);
		if(caiDui(result)){
			break;
		}
	}
}

	public abstract String suiji();

	public abstract void tishi() ;

	public abstract String bijiao(String c,String r) ;

	public abstract boolean caiDui(String result);
}