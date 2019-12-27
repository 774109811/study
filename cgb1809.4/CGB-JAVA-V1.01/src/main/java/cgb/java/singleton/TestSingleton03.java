package cgb.java.singleton;
import java.text.SimpleDateFormat;
import java.util.Date;


class DateUtils00{//线程安全
	//每次访问都创建SimpleDateFormat 就影响效率
	public static  String format(Date date){
		SimpleDateFormat sdf=
				new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	//将对象转乘串
	public static Date parse(String dateStr)
	throws Exception{
		SimpleDateFormat sdf=
		new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr);
	}
}



class DateUtils01{//线程不安全(不可取)
	//SimpleDateFormat对象是一个线程不安全的对象
	//format(),parse()这两个方法使用同一个对象就是不安全的
	private static SimpleDateFormat sdf=
	new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
	public static  String format(Date date){
		System.out.println(sdf.format(date));
		return sdf.format(date) ;//把日期转化成字符串
	}
	public static Date parse(String dateStr)
	throws Exception{
		return sdf.parse(dateStr);//把字符串对象解析成日期格式
	}
}

//线程内部的单例
class DateUtils02{
	private static ThreadLocal<SimpleDateFormat>
	    sdf=new ThreadLocal<SimpleDateFormat>(){
		//当在不同线程访问工具类中的format,parse方式
		//此方法会被调用，每个线程调用一次，此方法返回
		//的对象会绑定到当前线程
		protected SimpleDateFormat initialValue() {
			System.out.println("initialValue");
			//创建一个线程单例对象
			return new SimpleDateFormat("yyyy/MM/dd");
		};
	};
	public static  String format(Date date){
		String dateStr=sdf.get().format(date);
		System.out.println(dateStr);
		return dateStr;
	}
	public static Date parse(String dateStr)
	throws Exception{
		return sdf.get().parse(dateStr);
	}
}






public class TestSingleton03 {
	public static void main(String[] args) {
		String format = DateUtils02.format(new Date());
		String format2 = DateUtils02.format(new Date());
		System.out.println(format==format2);
		new Thread(){
			public void run() {
				
				String format3 = DateUtils02.format(new Date());
				String format4 = DateUtils02.format(new Date());
				System.out.println(format3==format4);
			};
		}.start();
	}
}
