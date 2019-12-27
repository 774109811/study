package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class Point{
	private int x;
	private int y;
	public Point() {}
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
public class TestReflect01 {
	/**类对象(字节码对象)的获取:每个类都有一个类对象*/
	static void doClass()throws Exception{
		Class<?> c1=Point.class;
		Class<?> c2=Class.forName("reflect.Point");
		Point p1=new Point();
		Class<?> c3=p1.getClass();
		System.out.println(c1==c2);//true
		System.out.println(c2==c3);//true
	}
	/**通过反射技术构建对象*/
	static Object doConstructor()throws Exception{
		//1.获取类对象
		Class<?> c1=Class.forName("reflect.Point");
		//2.基于类对象获取构造方法对象(无参构造)
		Constructor<?> con=c1.getDeclaredConstructor();
		//3.设置构造方法可访问(可能是私有)
		con.setAccessible(true);
		//4.基于构造方法构建类的实例
		Object p=con.newInstance();
		System.out.println(p);
		return p;
	}
	static void doConstructor(Object[] args,Class<?>... parameterType)throws Exception{
		//1.获取类对象
		Class<?> c1=Class.forName("reflect.Point");
		//2.基于类对象获取构造方法对象(有参构造)
		Constructor<?> con=
		c1.getDeclaredConstructor(parameterType);
		//3.设置构造方法可访问(可能是私有)
		con.setAccessible(true);
		//4.基于构造方法构建类的实例
		Object p=con.newInstance(args);
		System.out.println(p);
	}
	static void doField()throws Exception{
	  //获取类对象
	  Class<?> c1=Class.forName("reflect.Point");
	  //基于类对象获取属性对象
	  Field fx=c1.getDeclaredField("x");//public,private,...
	  //设置属性对象可访问
	  fx.setAccessible(true);
	  //为对象的属性赋值
	  Object obj=doConstructor();
	  fx.set(obj, 100);
	  //获取对象属性的值
	  System.out.println("x="+fx.get(obj));
	}
	public static void main(String[] args) throws Exception{
		doClass();
		doConstructor(new Object[]{10,30},int.class,int.class);
	    doField();
	}
}
