package day0801;

import java.util.Random;

public class GuessNumberGame extends GuessGame {

	@Override
	public String suiji() {
		int r =1+new Random().nextInt(1000);
	    String s=String.valueOf(r);
	    return s;
	}
	@Override
	public void tishi() {
	 System.out.println("�Ѿ������˸�[1��10001����Χ���������");
	 System.out.println("��²�������Ǽ�");	
	}
	@Override
	public String bijiao(String c,String r) {
//		���ַ���ת��INT����
		int a=Integer.parseInt(c);
		int b=Integer.parseInt(r);
		if(a>b){
			return "��";
		}else if(a<b){
			return "С";
		}else{
			return "��";
		}
	}
	@Override
	public boolean caiDui(String result) {
//		�ȽϷ���.equals()�ǶԵĻ���ֱ�����
		return "��".equals(result);
	}
	
}
