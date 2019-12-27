package cgb.java.proxy.jdk;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
//2222222222222222没有实现接口的
//难点：授权+缓存美哟有
//JDK动态代理：有目标对象(实现类)，没有目标对象实现类
public class DaoProxy implements InvocationHandler{
	@Override
	public Object invoke(Object proxy, 
			Method method, 
			Object[] args) throws Throwable {
		List<String> list=new ArrayList<>();
		list.add("tedu 1808");
		
		list.add("tedu 1809");
		//此位置可以通过SqlSession访问数据库
		//session.getMapper(XXXDao.class);
		return list;
	}
	//为代理对象产生代理类
	public <T>T newProxy(Class<T> targetCls){
		@SuppressWarnings("unchecked")
		T t=(T)Proxy.newProxyInstance(
				targetCls.getClassLoader(),
				new Class[]{targetCls},//目标类
				this);
		return t;
	}
}
