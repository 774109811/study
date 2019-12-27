package cgb.java.singleton;
import java.util.ArrayList;
import java.util.List;
/**
 * 类的设计：
 * 
 * 1)此类不能在外界直接构建对象：构造方法私有化
 * 2)此类要对外提供一个对象(有且仅有一个，具备全局唯一性)
 * 2.1)在类的内部构建对象
 * 2.2)对外提供一个全局访问点
 * 
 * 此种设计一般我们称之为单例设计:(单例模式)
 * 
 * 单例模式类型：
 * 1)懒汉式单例:(对象使用时创建,延迟加载)
 * a)保证线程安全：
 * b)优化加锁方式:
 * 2)饿汉式单例:(对象在类加载时创建)
 * a)思考对象大小(小对象可在类加时创建，大对象要延迟加载)
 */
//111
class Singleton01{//Singleton01.class
	private Singleton01(){}
	private static Singleton01 instance;
	/**
	 * 线程不安全：
	 * 1)存在并发执行的线程
	 * 2)存在共享数据集(instance)
	 * 3)在共享数据集上的操作不是原子操作
	 * @return
	 */
	public static Singleton01 getInstance(){
		while(instance==null){
			instance=new Singleton01();
		}
		return instance;
	}
}
//222线程安全 加锁 效率低
class Singleton02{//大对象，稀少用
	private Singleton02(){}
	private static Singleton02 instance;
	/**
	 * 悲观锁(排它锁)：某一时刻只能有一个线程执行代码内容。
	 * @return
	 */
	public static synchronized Singleton02 getInstance(){
		if(instance==null){
			instance=new Singleton02();
		}
		return instance;
	}
	//@(false)表示不公平的锁 
  /*static ReentrantLock lock=new ReentrantLock(false);
	public static Singleton02 getInstance(){
		try{
		lock.lock();
		if(instance==null){
			instance=new Singleton02();
		}
		return instance;
		}finally{
		lock.unlock();
		}
	}*/
}


//333效率稍微提升 锁的范围越小越好 但还是有阻塞,用的次数多的话不行
class Singleton03{//大对象，稀少用
	private Singleton03(){}
	/**
	 * volatile 可以保证线程的可见性(当使用此修饰符
	 * 修饰一个属性时，只要有一个线程改变了此属性的值，
	 * 对其它线程立刻可见。)，但不能保证原子性。
	 */
	private static volatile Singleton03 instance;
	
	public  static Singleton03 getInstance(){
		if(instance==null){
			//最坏情况的是所有线程都会进行此代码块
			//最好情况只有一个线程会进入如下代码块
			synchronized (Singleton03.class) {
				if(instance==null){
				 instance=new Singleton03();
				}
				System.out.println("");
				//......其它操作
			}//synchronized可以保证操作原子性，可见性
		}//减少阻塞线程的数量(通过双重判定)
		return instance;
	}
	public static void show(){}//其它方法
}

//444安全没有阻塞,但是类加载就会创建 如果是小的对象就可以用
//如果对象比较大就比较占用内存,浪费资源
class Singleton04{//小对象，频繁用
	/**对象构建时会初始化此属性*/
	//一个数占4个字节
	//private int[]array=new int[2048];//大对象
	private Singleton04(){}
	/**
	 * 类加载时会初始化此属性，而且只初始化1次
	 * 类加载时就会创建这个对象
	 */
	private static Singleton04 instance=new Singleton04();
	public static Singleton04 getInstance(){
		return instance;
	}
	public static void show(){}
}
//555 大对象单例优化也不会影响性能 
//有一点额外的内存占用内部类封装
class Singleton05{//大对象，频繁用
	//实例变量在对象创建的时候初始化(此变量占用资源比较多)
	private int[]array=new int[2048];
	private Singleton05(){}
	//静态内部类(构建对象，访问类属性，获取方法时，会加载类)
	static class Inner{//使用内部类延迟对象创建
		static {//只会初始化一次
			System.out.println("iner");
		}
	  private static  Singleton05 instance=
	  new Singleton05();
	}
	//对外的全局访问点(通过此方法获取对象)
	public static Singleton05 getInstance(){
		//访问内部类的instance属性
		return Inner.instance;
	}
	//频繁访问show方法时，是不会加载Inner类的
	public static void show(){
		System.out.println("show()");
	}
	//拿到实例对象后才可以调用此方法
	public void put(int a){
		array[0]=a;
	}
}
/**
 * 枚举类：使用enum定义的类为一个枚举类型(特殊的类)。
 * 应用场景：通常用于定义固定的一些常量值。
 * 例如
 * 1):一年四个季度 常量值(固定的值)
 * 2):一周七天 常量值
 * 3):订单状态，性别,..... 常量值
 * 
 * enum Gender{//性别
 *    MALE(男),FEMALE(女实例对象)
 * };//Gender中的两个值通常会认为这是两个对象实例
 * 
 */
//默认就是单例
enum Singleton06{//Singleton06.class
	instance;//单例对象(类加载时创建，且只创建一次)
	/*private Singleton06() {//不能使用public修饰
		System.out.println("Singleton06()");
	}//默认构造方法不写就有一个私有的构造函数
	*/
	/**
	 * 外界如何访问此方法
	 * Singleton06.instance.show();
	 */
	
	public void show(){
	}
}
public class TestSingleton01 {
	public static void main(String[] args) {
	//doMethod01();
	doMethod02();
	}
	public static void doMethod02(){
		List<Thread> list=new ArrayList<>();
		for(int i=0;i<10;i++){
		  Thread t=new Thread(){
			@Override
			public void run() {
				System.out.println(Singleton05.getInstance());
				Singleton05 instance = Singleton05.getInstance();
				instance.put(10);
				//Singleton06.instance.show();
			}
		  };
		  list.add(t);
		}
		for(Thread t:list){
			t.start();//就绪状态，获得CPU以后会执行run方法
		}
	}
    /**
     * alt+shift+m//把方法移除来
     */
	private static void doMethod01() {
		Singleton01 t1=Singleton01.getInstance();
		Singleton01 t2=Singleton01.getInstance();
		System.out.println(t1==t2);
	}
}
