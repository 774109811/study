package cgb.java.oop;

import java.util.HashMap;

public class TestOOP03 {
	private static class Container{
		//构建对象的时候首先要初始化
		private static Container instance=new Container();
		
		private  HashMap<String, Object> map=new HashMap<>();//类加载时初始化执行
		//构造方法私有化
		private  Container() {
			map.put("A", 100);
			map.put("B", 200);
		}
		public static Container getInstance() {
			/*
			 * if(instance==null) { instance = new Container(); }
			 */
			return instance;
		}
		public  void doPrint() {
			System.out.println(map);
		}
	}
	
	
	public static void main(String[] args) {
		
		Container instance = Container.getInstance();
		
		instance.doPrint();
	}
}
