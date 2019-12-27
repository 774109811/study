package day0902;

public class Text3 {
	public static void main(String[] args) {
		Weapon w=f();
		w.kill();
		System.out.println(w);
	}

	private static Weapon f() {
		class AK47 implements Weapon{

			@Override
			public void kill() {
				System.out.println("AK47…®…‰");
				
			}
			
		}
		AK47 a=new AK47();
		return a;
	}
}
