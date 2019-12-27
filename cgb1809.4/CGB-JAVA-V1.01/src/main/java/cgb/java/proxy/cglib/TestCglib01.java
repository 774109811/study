package cgb.java.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
///1111
class FileSearchService{
	void search(String msg){
		System.out.println("search "+msg+" from file system");
	}
}//JDK内置的Proxy类不能为没有实现接口的类产生动态代理对象
class DatabaseSearchService{
	void search(String msg){
		System.out.println("search "+msg+" from database system");
	}
}

/*class SubFileSearchService extends FileSearchService{
	@Override
	void search(String msg) {
	    long t1=System.currentTimeMillis();
		super.search(msg);
		long t2=System.currentTimeMillis();
		System.out.println("execute time:"+(t2-t1));
	}
}*/
//2222
class CGLIBProxy implements MethodInterceptor{
	
	//相当于InvocationHandler中的invoke方法3333
	@Override
	public Object intercept(Object obj, //Enhancer
			Method method, //目标方法
			Object[] args, //实际参数
			MethodProxy proxy) throws Throwable {
		long t1=System.currentTimeMillis();
		//执行目标方法
		Object result=proxy.invokeSuper(obj, args);
		long t2=System.currentTimeMillis();
		System.out.println("execute time :"+(t2-t1));
		return result;//目标方法的执行结果
	}
	//2222
	public Object newCglibProxy(Object target){
		Enhancer en=new Enhancer();//类似JDK中的Proxy
		//cgblib底层就是继承后重写方法
		//设置代理对象父类类型
		en.setSuperclass(target.getClass());
		//回调函数
		en.setCallback(this);//this指的就是CGLIBProxy
		//创建代理
		Object proxy=en.create();
		return proxy;
	}
}
public class TestCglib01 {
	public static void main(String[] args) {
		FileSearchService target=new FileSearchService();
		CGLIBProxy cProxy=new CGLIBProxy();
		FileSearchService proxy=
		(FileSearchService)cProxy.newCglibProxy(target);
		System.out.println(proxy.getClass().getName());
		proxy.search("tedu");
	}
}



