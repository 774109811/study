package day0901;

public class Transformer {
	//���ν�������ӿ�
	private Weapon  w;
//	set�������ı������Ը�����������
	public void setWeapon(Weapon w){
		this.w=w;
}
	public void attack(){
		//û������
		if(w==null){
			System.out.println("����ҧ");
			return;
		}
		/*/w.getType()������
		 * ת�����ַ�����������������ȱ�����������������
		 */
		String t= "";
		switch(w.getType()){
		case 0: t="�����";break;
		case 1: t="�ȱ���";break;
		case 2: t="������";break;
		}
		//ʹ���Ǹ���������
		System.out.println("ʹ��"+t+w.getName()+"����");
		w.kill();
	}
}