package day1202_��ϰ;
/*
 * ��װ
 *     ��ʿ����ص��������ݣ�
 *     ��������룬��װ��һ�����ࡱ���
 */
import java.util.Random;

public class Soldier {
	   //��������
	   //��Ա����
	    int id;//Ĭ����0
		int blood =100;
		//���췽��
		public Soldier(){
		
		}
		
		
		//��Ա����
		public void go(){
			int a =new Random().nextInt(1000);
			System.out.println(id+"��ʿ��ǰ��"+a+"��");
		}
		public void attack(){
			if (blood==0) {
				System.out.println("����"+id+"��ʿ����ʬ��");
				return;
			}
			System.out.println(id+"��ʿ������");
			//���������Ѫ��
			int d=new Random().nextInt(50);
			blood-=d;
			if(blood<0){//Ѫ���������Ǹ���
				blood=0;  
			}
			System.out.println(id+"Ѫ��"+blood);
			if(blood==0){
				System.out.println(id+"��ʿ������");
			}
			
		}
	}
//
//            int id;
//            int blood;
//            
//            public void go(){
//            	System.out.println(id+"ʿ��ǰ��");
//            }
//            public void attack(){
//            	if(blood==0){
//            		System.out.println("zheshi"+id+"shiti");
//            	}
//            	System.out.println(id+"�Ż��ӽ���");
//            	int a = new Random().nextInt(15);
//            	blood-=a;
//            	if(blood<0){
//            		blood=0;
//            	}
//            	System.out.println(id+"Ѫ��"+blood);
//            	if(blood==0){
//            		System.out.println(id+"��ʿ������");
//            	}
//            }