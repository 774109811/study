package stream;

import org.junit.Test;

public class TestSwitch {

	@Test
	public void test() {
		String param = null;
		switch (param) {
		case "null":
			System.out.println("null");
			break;
		default:
			System.out.println("default");
		}
		
	}
	@Test
	public void test1() {
		  String param = "a";
	        switch (param) {
	            case "a":
	                System.out.println("a");
	                break;
	            case "b":
	                System.out.println("b");
	                break;
	            case "c":
	                System.out.println("c");
	                break;
	            default:
	                System.out.println("default");
	        }
	}
	
	
}