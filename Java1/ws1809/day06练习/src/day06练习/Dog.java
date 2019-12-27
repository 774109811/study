package day06练习;

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
			System.out.println(name+"吃饱了，谢谢！");
		}
		System.out.println("给"+name+"喂食");
		if(full<60){
			System.out.println(name+"该吃饭了，麻烦了主人");
			full+=10;
		}
		full+=10;
		
		System.out.println("饥饿度"+full);
	}
	public void play(){
		if(full==60){
			System.out.println(name+"玩不动啦，该吃东西啦");
			return;
		}
		System.out.println("陪"+name+"玩");
		happy+=10;
		full-=10;
		System.out.println("快乐值："+happy+"饥饿值："+full);
	}
	public void punish(){
		System.out.println("打"+name+"的PP"+name+"哭叫：aaaaaa");
		happy-=10;
		System.out.println("快乐度："+happy);
	}
}
