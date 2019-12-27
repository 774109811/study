package day0901;

public class Lyb implements Weapon {
	@Override
	public void kill() {
		System.out.println("°ô´ò");
		
	}

	@Override
	public String getName() {
		return "ÀÇÑÀ°ô";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return Weapon.TYPE_NUCLEAR;
	}
}
