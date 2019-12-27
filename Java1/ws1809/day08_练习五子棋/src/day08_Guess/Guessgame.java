package day08_Guess;

import java.util.Scanner;

public abstract class Guessgame {
	public void start() {
		String r= suiji();
		System.out.println(r);
		tishi();
		while(true){
			System.out.println("²Â£º");
			String c= new Scanner(System.in).nextLine();
			String result =bijiao(c,r);
			System.out.println(result);
			if(caidui(result)){
				break;
			}
		}
		

	}



	public abstract String suiji();
	public abstract void tishi();
	public abstract String bijiao(String c, String r);
	private boolean caidui(String result);

}
