package day09_Á·Ï°;

public class Transformer {
	private Weapon w;
	public void setWeapon(Weapon w){
		this.w = w;
	}
	public void attack() {
		if(w == null){
			System.out.println("ÓÃP±Ä");
		}
		String r ="";
		switch(w.getType()){
		case 0: r="Àä±øÆ÷";break;
		case 1: r="ÈÈ±øÆ÷";break;
		case 2: r="ºËÎäÆ÷";break;
		case 3: r="ÎäÆ÷";break;
		}
		System.out.println("Ê¹ÓÃ"+r+w.getName()+"¹¥»÷");
		w.kill();
	}
	
}
