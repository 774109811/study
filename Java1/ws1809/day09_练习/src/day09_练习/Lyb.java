package day09_��ϰ;

public class Lyb implements Weapon {

	@Override
	public void kill() {
		System.out.println("����");
		
	}

	@Override
	public String getName() {
		return "������";
	}

	@Override
	public int getType() {
		
		return Weapon.TYPE_COLD;
	}

}
