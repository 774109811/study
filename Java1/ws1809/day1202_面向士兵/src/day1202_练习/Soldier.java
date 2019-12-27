package day1202_练习;
/*
 * 封装
 *     把士兵相关的属性数据，
 *     和运算代码，封装成一个“类”组件
 */
import java.util.Random;

public class Soldier {
	   //属性数据
	   //成员变量
	    int id;//默认是0
		int blood =100;
		//构造方法
		public Soldier(){
		
		}
		
		
		//成员方法
		public void go(){
			int a =new Random().nextInt(1000);
			System.out.println(id+"号士兵前进"+a+"米");
		}
		public void attack(){
			if (blood==0) {
				System.out.println("这是"+id+"号士兵的尸体");
				return;
			}
			System.out.println(id+"号士兵进攻");
			//产生随机减血量
			int d=new Random().nextInt(50);
			blood-=d;
			if(blood<0){//血量不允许是负数
				blood=0;  
			}
			System.out.println(id+"血量"+blood);
			if(blood==0){
				System.out.println(id+"号士兵阵亡");
			}
			
		}
	}
//
//            int id;
//            int blood;
//            
//            public void go(){
//            	System.out.println(id+"士兵前进");
//            }
//            public void attack(){
//            	if(blood==0){
//            		System.out.println("zheshi"+id+"shiti");
//            	}
//            	System.out.println(id+"号皇子进攻");
//            	int a = new Random().nextInt(15);
//            	blood-=a;
//            	if(blood<0){
//            		blood=0;
//            	}
//            	System.out.println(id+"血量"+blood);
//            	if(blood==0){
//            		System.out.println(id+"号士兵阵亡");
//            	}
//            }