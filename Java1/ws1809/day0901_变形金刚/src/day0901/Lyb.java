package day0901;

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
		// TODO Auto-generated method stub
		return Weapon.TYPE_NUCLEAR;
	}
}
