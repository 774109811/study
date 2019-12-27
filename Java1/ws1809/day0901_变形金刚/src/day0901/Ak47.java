package day0901;

public class Ak47 implements Weapon {
	public void kill() {
		System.out.println("…®…‰");
		
	}

	@Override
	public String getName() {
		return "AK47";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return Weapon.TYPE_HOT;
	}
}
