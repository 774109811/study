package day11_练习算法;

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
	//辅助创建迭代器对象                                                                                                                                                                                                                                                                                                                                                                                                                                       
	public DieDaiQi iterator(){
		return new DieDaiQi();
		
	}
	//迭代器类查找
	class DieDaiQi{ 
		int from;//每次查找的起始位置下标
		Matcher m =Pattern.compile("\\d+(\\.\\d+)?|[+\\-*/]").matcher(f);
		
		public String next(){		
			m.find(from);//从from向后找
			String s = m.group();//提取找到的子串
			from = m.end();//from定位到这一段末尾
			return s;
		}
		public boolean hasNext(){
			//判断hex 下表位置不能超过长度
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
				 //取出数字
				 list1.add(Double.parseDouble(s));
			 }else if(s.matches("[+\\-*/]")){
                 // 取出+-符号
				 list2.add(s.charAt(0));	 
			 }else{//乘除的情况
				 //把乘号前面的取出
				 double a = list1.removeLast();
				 //把称号后的取出
				 double b = Double.parseDouble(it.next());
				 
				 double c = jisuan(a,s.charAt(0),b);
				 list1.add(c);
			 }
		 }
		 //while结束
		 //当还有加减号	 
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
