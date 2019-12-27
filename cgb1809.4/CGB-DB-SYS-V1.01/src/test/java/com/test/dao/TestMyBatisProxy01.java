package com.test.dao;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import com.db.sys.dao.SysLogDao;
import com.test.TestBase;
class DaoProxy implements InvocationHandler{//代理对象实现实现执行适配器,实现后执行invoke方法
	private SqlSessionFactory factory;
	public DaoProxy(SqlSessionFactory factory){
		this.factory=factory;//构造函数拿到factory，拿到opensession对象的session
	}
	public Object invoke(Object proxy,Method method,//实现后执行invoke方法
			Object[] args) throws Throwable {//对象,方法和参数
		System.out.println("invoke");
		SqlSession session=factory.openSession();
		Object dao=session.getMapper(proxy.getClass().getInterfaces()[0]);//获得接口
		//拿到dao代理对象
		System.out.println("invoke.proxy="+dao.getClass().getName());
		//执行方法
		Object result=method.invoke(dao, args);//方法执行
		
		session.close();//关闭session
		return result;
	}
	@SuppressWarnings("unchecked")
	public <T>T getProxy(Class<?> targetCls){
		return (T)Proxy.newProxyInstance(//新建一个代理对象
				targetCls.getClassLoader(),//目标对象获得类加载
				new Class[]{targetCls},//代理对象要实现的接口
				this);//处理适配器当前对象
	}
}
public class TestMyBatisProxy01 extends TestBase{
	@Test
	public void testDaoProxy(){
		SqlSessionFactory factory=ctx.getBean(
		"sqlSessionFactory",SqlSessionFactory.class);//获取工厂bean对象
		DaoProxy dProxy=new DaoProxy(factory);//新建接口代理对象
		SysLogDao dao=dProxy.getProxy(SysLogDao.class);//获取目标接口代理对象
		System.out.println("test.proxy="+dao.getClass().getName());
		//int rows=dao.getRowCount("admin");
		//System.out.println(rows);
		Object obj=dao.findPageObjects("admin",1, 3);//执行接口中的方法
		System.out.println(obj);
	}
}







