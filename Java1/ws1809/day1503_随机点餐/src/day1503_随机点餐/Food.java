package day1503_随机点餐;
//实现了comparable接口对象，具有直接比较大小能力
public class Food implements Comparable<Food> {
	private String name;
	private int times;
	
	public Food() {
		super();
	}
	public Food(String name, int times) {
		super();
		this.name = name;
		this.times = times;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
		
		
	} 
	@Override
	public String toString() {
		
		return name+";"+times;
	}
	
//	当前对象于参数对象o比较大小
//	当前对象大返回整数
//	当前对象小返回负数
//	相等返回0
	@Override
	public int compareTo(Food o) {
		//当前对象于参数对象比较
		return times-o.times;
	}

}
