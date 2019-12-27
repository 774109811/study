package day08_练习;

import java.util.Random;

public class GuessNumberGame extends GuessGame {

	@Override
	public String suiji() {
		int r =1+new Random().nextInt(1000);
		String s=String.valueOf(r);
		return s;
	}

	@Override
	public void tishi() {
		System.out.println("已经产生了个[1，10001）范围的随机整数");
		 System.out.println("请猜猜这个数是几");
		
	}

	@Override
	public String bijiao(String c, String r) {
		int a= Integer.parseInt(c);
		int b= Integer.parseInt(r);
		if(a>b){
			return "大";
		}else if(a<b){
			return "小";
		}else{
			return "对";
		}
	}

	@Override
	public boolean caidui(String result) {
		// TODO Auto-generated method stub
		return "对".equals(result);
	}

}
