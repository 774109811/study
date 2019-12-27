package day0801;

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
	public String bijiao(String c,String r) {
//		把字符串转成INT类型
		int a=Integer.parseInt(c);
		int b=Integer.parseInt(r);
		if(a>b){
			return "大";
		}else if(a<b){
			return "小";
		}else{
			return "对";
		}
	}
	@Override
	public boolean caiDui(String result) {
//		比较方法.equals()是对的话就直接输出
		return "对".equals(result);
	}
	
}
