package day09_��ϰ;

public class Transformer {
	private Weapon w;
	public void setWeapon(Weapon w){
		this.w = w;
	}
	public void attack() {
		if(w == null){
			System.out.println("��P��");
		}
		String r ="";
		switch(w.getType()){
		case 0: r="�����";break;
		case 1: r="�ȱ���";break;
		case 2: r="������";break;
		case 3: r="����";break;
		}
		System.out.println("ʹ��"+r+w.getName()+"����");
		w.kill();
	}
	
}
