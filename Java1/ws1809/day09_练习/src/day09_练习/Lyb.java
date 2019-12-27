package day09_Á·Ï°;

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
		
		return Weapon.TYPE_COLD;
	}

}
