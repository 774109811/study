package day08_��ϰ;

public class GuessLetterGame extends GuessGame{

	@Override
	public String suiji() {
		
		return "ABCDE";
	}

	@Override
	public void tishi() {
		System.out.println("�Ѿ����������5�����ظ��Ĵ�д��ĸ");
		System.out.println("�����5����ĸ");
	}

	@Override
	public String bijiao(String c, String r) {
		// TODO Auto-generated method stub
		return "2A2B";
	}

	@Override
	public boolean caidui(String result) {
		// TODO Auto-generated method stub
		return  "5A0B".equals(result);
	}

}
