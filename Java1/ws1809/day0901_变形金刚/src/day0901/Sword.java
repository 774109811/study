package day0901;

public class Sword implements Weapon{

	@Override
	public void kill() {
		System.out.println("ˣ��");
		
	}

	@Override
	public String getName() {
		return "���콣";                             
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return Weapon.TYPE_COLD;
	}
	
}
