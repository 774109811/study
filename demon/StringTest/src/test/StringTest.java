package test;

public class StringTest {
	public static void main(String[] args) {
		String a="asdasd/dasdafgasd/afasd/";
		//字符串分隔符
		String[] split = a.split("/");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
		//System.out.println(split[0]);
		//把0位置的换成空
		String replace = a.replace(split[0]+"/", "");
		System.out.println(replace);
	}
}
