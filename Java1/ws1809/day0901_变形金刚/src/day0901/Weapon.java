package day0901;
       //�����ӿ�
public interface Weapon {
//	�����ĳ������ӿ���û�б������� int a=11��
//	public static final
	int TYPE_COLD    =0;
	int TYPE_HOT     =1;
	int TYPE_NUCLEAR =2;

//	�����ĳ��󷽷�
//	public abstract
	
	void kill();
	//��������
	String getName();
	//�������ֱ�����������
	int getType();
}
