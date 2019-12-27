package jd.factory;

public class JdFactory {
	public static Food getFood(String food) {
		Food food1=null;
		switch(food) {
		case "ManTou":
			food1 = new ManTou();
			break;
		case "MiFan":
			food1 = new Mifan();
			break;
		case "BaoZi":
			food1 = new Baozi();
			break;
		}
		return food1;
	}
}
