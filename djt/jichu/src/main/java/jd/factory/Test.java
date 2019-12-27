package jd.factory;

public class Test {
	public static void main(String[] args) {
		JdFactory jdFactory = new JdFactory();
		Food food = jdFactory.getFood("ManTou");
	
		Food food2 = jdFactory.getFood("BaoZi");
		food.eat();
		
		food2.eat();
	}
}
