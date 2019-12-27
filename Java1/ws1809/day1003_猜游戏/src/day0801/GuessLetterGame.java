package day0801;

import java.util.Random;
import java.util.Scanner;

public class GuessLetterGame extends GuessGame {

	@Override
	public String suiji() {
//		新建StringBuilder对象包含26个字母；
		StringBuilder sb= new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//		循环访问前5个位置
		for(int i =0;i<5;i++){
//			26个位置中随机定位
			int j =new Random().nextInt(26);
//			交换位置并赋值是set
			char t =sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, t);
		}
		sb.delete(5,26);
		return sb.toString();
	}
	@Override
	public void tishi() {
		System.out.println("已经随机产生了5个不重复的大写字母");
		System.out.println("请猜这5个字母");
	}
	@Override
	public String bijiao(String c, String r) {
//		对错命名a和b
		int a=0;
		int b=0;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if( c.charAt(i)==r.charAt(j)){
					if(i==j) a++;
					else b++ ;
					break;
				}
			}
		}
		return a+"A"+b+"B";
	}
	@Override
	public boolean caiDui(String result) {
		return "5A0B".equals(result);
	}
	
}
