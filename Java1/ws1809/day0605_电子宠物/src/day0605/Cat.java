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
			System.out.println(name+"已经吃不下了");
			return;
		}
		System.out.println("给"+name+"喂食");
		full+=10;
		System.out.println("饱食度"+full);
	}
	public void play(){
		if(full==0){
			System.out.println(name+"饿的玩不动了");
			return;
		}
		System.out.println("陪"+name+"玩耍");
		happy+=10;
		full-=10;
		System.out.println("快乐度"+happy+",饱食度"+full);
		
	}
	public void punish(){
		System.out.println("打"+name+"的pp，"+"哭叫：汪~");
		happy-=10;
		System.out.println("快乐度"+happy);
	}
	
}
