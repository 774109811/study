package day09_��ϰ;

public class M41 implements Weapon {

	
	@Override
	public void kill() {
		System.out.println("ɨ��");
		
	}

	@Override
	public String getName() {
		return "M41";
	}

	@Override
	public int getType() {
		
		return Weapon.TYPE_NUCLEAR;
	}
	
}
