package day0904;

public class Text2 {
	public static void main(String[] args) {
		String s0="abcdefghijklmnopqrstuvwxyz";
		String s="";
		//ϵͳʱ�����ֵ
        //��1970-1-1		
		long t = System.currentTimeMillis();
		for(int i =0;i<10000;i++){
			s=s+s0;
		}
		t =System.currentTimeMillis()-t;
		System.out.println(t);
	}
}