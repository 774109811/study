	package day0604;

public class Car {
		String brand;
		String color;
		int speed;
		
		public Car(String brand,String color,int speed){
			
		}
		public void go() {
			System.out.println(color+brand+"前进时速"+speed);

		}
		public void stop() {
			System.out.println(color+brand+"停止");
		}
}
