package gcff.factory;

public class TestGCFactory {
	public static void main(String[] args) {
		MiFanFactory miFanFactory = new MiFanFactory();
		miFanFactory.creatFactory().eat();
		ManTouFactory manTouFactory = new ManTouFactory();
		manTouFactory.creatFactory().eat();
		BaoZiFactory baoZiFactory = new BaoZiFactory();
		baoZiFactory.creatFactory().eat();
	}
}
