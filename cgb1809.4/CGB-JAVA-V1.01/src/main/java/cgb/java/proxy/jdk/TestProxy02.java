package cgb.java.proxy.jdk;

import java.util.List;
//22222222222222222 
public class TestProxy02 {

	public static void main(String[] args) {
		DaoProxy dProxy = new DaoProxy();
		SearchDao dao= dProxy.newProxy(SearchDao.class);
		
		System.out.println(dao.getClass().getName());
		List<String> list=dao.search("asd");
		
		System.out.println(list);
		
	}
}
