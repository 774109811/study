package day0604;

public class Text1 {
	public static void main(String[] args) {
		Car c1=new Car("法拉利","红色",1000);
		Car c2=new Car("梅色塞斯","褐色",500);
		
//		c1.brand="法拉利";
//		c1.color="红色";
//		c1.speed=1000;
//		c2.brand="梅色塞斯";
//		c2.color="褐色";
//		c2.speed=500;
		
		c1.go();
		c2.stop();
	}
}
