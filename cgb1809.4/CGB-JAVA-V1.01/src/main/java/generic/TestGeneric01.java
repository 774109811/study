package generic;
import java.lang.reflect.Method;
import java.util.ArrayList;
public class TestGeneric01 {
	public static void main(String[] args)
	throws Exception{
		ArrayList<String> list=new ArrayList<>();
		list.add("A");
		list.add("B");
		//list.add(200);
		//基于反射技术将200写入到list集合
		//1)获取class对象
		Class<?> cls=list.getClass();
		//2)获取类中的方法对象第一个参数方法名,第二个是参数类型
		Method m=cls.getDeclaredMethod("add",
				Object.class);
		//3)执行方法对象(执行list集合的m方法)
		//第一个参数时list对象,第二个是要添加的参数
		m.invoke(list,200);
		m.invoke(list,true);
		System.out.println(list);
	}
}
