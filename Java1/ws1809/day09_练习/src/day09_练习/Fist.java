package day09_��ϰ;

public class Fist implements Weapon {

	@Override
	public void kill() {
		System.out.println("��ȭ");
		
	}

	@Override
	public String getName() {
		
		return "����ȭ";
	}

	@Override
	public int getType() {
	
		return Weapon.TYPE_HOT;
	}
	
}
