package day06��ϰ;

public class Dog {
	String name;
	int full;
	int happy;
	
	
	public Dog(String name,int full,int happy){
		this.name=name;
		this.full=full;
		this.happy=happy;
		
		
		
	}
	public void feed(){
		if(full==100){
			System.out.println(name+"�Ա��ˣ�лл��");
		}
		System.out.println("��"+name+"ιʳ");
		if(full<60){
			System.out.println(name+"�óԷ��ˣ��鷳������");
			full+=10;
		}
		full+=10;
		
		System.out.println("������"+full);
	}
	public void play(){
		if(full==60){
			System.out.println(name+"�治�������óԶ�����");
			return;
		}
		System.out.println("��"+name+"��");
		happy+=10;
		full-=10;
		System.out.println("����ֵ��"+happy+"����ֵ��"+full);
	}
	public void punish(){
		System.out.println("��"+name+"��PP"+name+"�޽У�aaaaaa");
		happy-=10;
		System.out.println("���ֶȣ�"+happy);
	}
}
