package day09_��ϰ;

public interface Weapon {
	int TYPE_COLD = 0 ;
	int TYPE_HOT  = 1 ;
	int TYPE_NUCLEAR = 2 ;
	int TYPE_WUQI = 3 ;
	void kill();
	String getName();
	int getType();
}
