                          package day0202;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("�������16.4����");
		System.out.println("���� 299792458 ��/��");
		System.out.println("ϲȵ��0.46��");
		System.out.println("ţ��֯Ů�����Ҫ����ֻϲȵ");
		System.out.println((long)(299792458L*60*60*24*365/0.46*16.4));
		long ly = 299792458L*60*60*24*365;
		double d = 16.4*ly;
		double r =d/0.46;
		long n = (long) Math.ceil(r);
		System.out.println(n);
	}

}
