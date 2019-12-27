package day08_练习;

public class GuessLetterGame extends GuessGame{

	@Override
	public String suiji() {
		
		return "ABCDE";
	}

	@Override
	public void tishi() {
		System.out.println("已经随机产生了5个不重复的大写字母");
		System.out.println("请猜这5个字母");
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
