package day0801;

public class GuessLetterGame extends GuessGame {

	@Override
	public String suiji() {
		//TODO:�Ժ�����ɣ�д�ٴ���
		return "ABCDE";
	}
	@Override
	public void tishi() {
		System.out.println("�Ѿ����������5�����ظ��Ĵ�д��ĸ");
		System.out.println("�����5����ĸ");
	}
	@Override
	public String bijiao(String c, String r) {
		//TODO:�Ժ�����ɣ�д�ٴ���
				return "2A2B";
	}
	@Override
	public boolean caiDui(String result) {
		return "5A0B".equals(result);
	}
	
}
