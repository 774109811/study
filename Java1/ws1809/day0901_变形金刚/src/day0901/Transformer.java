package day0901;

public class Transformer {
	//变形金刚武器接口
	private Weapon  w;
//	set设置它的变量可以更改武器名称
	public void setWeapon(Weapon w){
		this.w=w;
}
	public void attack(){
		//没有武器
		if(w==null){
			System.out.println("用牙咬");
			return;
		}
		/*/w.getType()类别代码
		 * 转换成字符串“冷兵器”，“热兵器”，“核武器”
		 */
		String t= "";
		switch(w.getType()){
		case 0: t="冷兵器";break;
		case 1: t="热兵器";break;
		case 2: t="核武器";break;
		}
		//使用那个兵器进攻
		System.out.println("使用"+t+w.getName()+"进攻");
		w.kill();
	}
}