package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;

public class LambdaTest {
	public static void main(String[] args){
		int[] intArr=new int[]{1,2,3};
		//java8之前的写法
		Arrays.parallelSetAll(intArr, new IntUnaryOperator() {
			@Override
			public int applyAsInt(int operand) {
				return intArr[operand]*5;
			}
		});
		//用lambda改写
		Arrays.parallelSetAll(intArr,(int operand)->{
			return intArr[operand]*5;
		});
		//可省略形参类型声明
		Arrays.parallelSetAll(intArr,(operand)->{
			return intArr[operand]*5;
		});

		//-----------------------形参中只有一个参数--------------------
		//参数的圆括号可以省略,
		Arrays.parallelSetAll(intArr,operand -> {
			return intArr[operand]*5;
		});
		//-----------------------只有一条语句----------------------------
		//可以省略代码块的花括号
		new Thread(()-> System.out.println(1));
		//-----------------------只有一条return语句，--------------------
		// 可以省略return语句
		Arrays.parallelSetAll(intArr,operand->intArr[operand]*5);

		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.forEach((k,v)->{
			System.out.println("k="+k+",v="+v);
		});
	}
}
