package day0605;

public class Cat {
	String name;
	int full;
	int happy;
	public Cat(){
		
	}
    public Cat(String name){
		this.name=name;
		this.full=50;
		this.happy=50;
	}
    public Cat(String name,int full,int happy){
    	this.name=name;
		this.full=50;
		this.happy=50;
    }

	public void feed(){
		if(full==100){
			System.out.println(name+"�Ѿ��Բ�����");
			return;
		}
		System.out.println("��"+name+"ιʳ");
		full+=10;
		System.out.println("��ʳ��"+full);
	}
	public void play(){
		if(full==0){
			System.out.println(name+"�����治����");
			return;
		}
		System.out.println("��"+name+"��ˣ");
		happy+=10;
		full-=10;
		System.out.println("���ֶ�"+happy+",��ʳ��"+full);
		
	}
	public void punish(){
		System.out.println("��"+name+"��pp��"+"�޽У���~");
		happy-=10;
		System.out.println("���ֶ�"+happy);
	}
	
}
