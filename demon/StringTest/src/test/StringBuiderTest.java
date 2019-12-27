package test;

public class StringBuiderTest {
	public static void main(String[] args) {
		//不安全
		StringBuilder stringBuilder = new StringBuilder("aaa");
		StringBuilder append = stringBuilder.append("bbb").append("ccc");
		System.out.println(append);
		//安全
		StringBuffer stringBuffer = new StringBuffer();
		
	}
}
