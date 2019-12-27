package day11_��ϰ�㷨;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Formula {
	private String f;

	public Formula(String f) {
		f=f.trim();
		this.f = f;
	}
	//������������������                                                                                                                                                                                                                                                                                                                                                                                                                                       
	public DieDaiQi iterator(){
		return new DieDaiQi();
		
	}
	//�����������
	class DieDaiQi{ 
		int from;//ÿ�β��ҵ���ʼλ���±�
		Matcher m =Pattern.compile("\\d+(\\.\\d+)?|[+\\-*/]").matcher(f);
		
		public String next(){		
			m.find(from);//��from�����
			String s = m.group();//��ȡ�ҵ����Ӵ�
			from = m.end();//from��λ����һ��ĩβ
			return s;
		}
		public boolean hasNext(){
			//�ж�hex �±�λ�ò��ܳ�������
			return from<f.length();
			
		}
	}
	
	public double eval(){
		/*
	       * 341 + 3.1344 - 5234.4 * 0.42 / 545      
	       * 
	       * 
	       * 2323 4534
	       * ------------------------------------
	       * -
	       * ------------------------------------
	       * 341   +   3.1344   =  
	       */
		 LinkedList<Double> list1 =new LinkedList<>();
		 LinkedList<Character> list2 =new LinkedList<>();
		 DieDaiQi it = iterator();
		 while(it.hasNext()){
			 String s = it.next();
			 if(s.matches("\\d+(\\.\\d+)?")){
				 //ȡ������
				 list1.add(Double.parseDouble(s));
			 }else if(s.matches("[+\\-*/]")){
                 // ȡ��+-����
				 list2.add(s.charAt(0));	 
			 }else{//�˳������
				 //�ѳ˺�ǰ���ȡ��
				 double a = list1.removeLast();
				 //�ѳƺź��ȡ��
				 double b = Double.parseDouble(it.next());
				 
				 double c = jisuan(a,s.charAt(0),b);
				 list1.add(c);
			 }
		 }
		 //while����
		 //�����мӼ���	 
		 while(list2.size()!=0){
			 double a =list1.removeFirst();
			 double b =list1.removeFirst();
			 char op =list2.removeFirst();
			 double c = jisuan(a,op,b);
			 list1.addFirst(c);
		 }
		return list1.get(0);
	}
	private double jisuan(double a, char op, double b) {
		BigDecimal a1 = BigDecimal.valueOf(a);
		BigDecimal b1 = BigDecimal.valueOf(b);
		BigDecimal b3 = null;
		
		switch(op){
		case '+': b3 = a1.add(b1);break;
		case '-': b3 = a1.subtract(b1);break;
		case '*': b3 = a1.multiply(b1);break;
		case '/': b3 = a1.divide(b1,4,BigDecimal.ROUND_HALF_EVEN);break;
		}
		return   b3.doubleValue();
	}
}
