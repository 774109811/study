package day0901;
       //武器接口
public interface Weapon {
//	公开的常量，接口里没有变量比如 int a=11；
//	public static final
	int TYPE_COLD    =0;
	int TYPE_HOT     =1;
	int TYPE_NUCLEAR =2;

//	公开的抽象方法
//	public abstract
	
	void kill();
	//武器名字
	String getName();
	//整数数字编码武器类型
	int getType();
}
