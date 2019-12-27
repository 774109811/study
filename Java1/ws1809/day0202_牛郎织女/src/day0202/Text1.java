                          package day0202;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("两星相距16.4光年");
		System.out.println("光速 299792458 米/秒");
		System.out.println("喜鹊身长0.46米");
		System.out.println("牛郎织女相会需要多少只喜鹊");
		System.out.println((long)(299792458L*60*60*24*365/0.46*16.4));
		long ly = 299792458L*60*60*24*365;
		double d = 16.4*ly;
		double r =d/0.46;
		long n = (long) Math.ceil(r);
		System.out.println(n);
	}

}
