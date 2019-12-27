package chouxiang.factory;

public class TestGCFactory {
	public static void main(String[] args) {
		ManTouFactory manTouFactory = new ManTouFactory();
		SmallFood createFactory = manTouFactory.createFactory();
		BigFood creatFactory = manTouFactory.creatFactory();
		createFactory.eat();
		creatFactory.eat();
	}
}
